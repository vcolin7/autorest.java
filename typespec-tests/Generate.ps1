function Generate($tspFile) {
  Write-Host "npx tsp compile $tspFile --trace import-resolution --trace projection --trace typespec-java"
  if ($tspFile -match "type[\\/]enum[\\/]extensible[\\/]*") {
    Invoke-Expression "npx tsp compile $tspFile --options=""@azure-tools/typespec-java.namespace=com.type.enums.extensible"" --trace import-resolution --trace projection --trace typespec-java"
  } elseif ($tspFile -match "type[\\/]enum[\\/]fixed[\\/]*") {
    Invoke-Expression "npx tsp compile $tspFile --options=""@azure-tools/typespec-java.namespace=com.type.enums.fixed"" --trace import-resolution --trace projection --trace typespec-java"
  } elseif ($tspFile -match "resiliency[\\/]srv-driven[\\/]old.tsp") {
    Invoke-Expression "npx tsp compile $tspFile --options=""@azure-tools/typespec-java.namespace=com.resiliency.servicedriven.v1"" --trace import-resolution --trace projection --trace typespec-java"
  } else {
    Invoke-Expression "npx tsp compile $tspFile --trace import-resolution --trace projection --trace typespec-java"
  }

  if ($LASTEXITCODE) {
    exit $LASTEXITCODE
  }

  if (Test-Path ./tsp-output/src/main/java/module-info.java) {
    Remove-Item ./tsp-output/src/main/java/module-info.java
  }

  if (Test-Path ./tsp-output/src/samples) {
    Remove-Item ./tsp-output/src/samples -Recurse -Force
  }

  Copy-Item -Path ./tsp-output/src -Destination ./ -Recurse -Force

  Remove-Item ./tsp-output -Recurse -Force
}

./Setup.ps1

New-Item -Path ./existingcode/src/main/java/com/cadl/ -ItemType Directory -Force

if (Test-Path ./src/main/java/com/cadl/partialupdate) {
  Copy-Item -Path ./src/main/java/com/cadl/partialupdate -Destination ./existingcode/src/main/java/com/cadl/partialupdate -Recurse -Force
}

if (Test-Path ./src/main) {
  Remove-Item ./src/main -Recurse -Force
}
if (Test-Path ./tsp-output) {
  Remove-Item ./tsp-output -Recurse -Force
}

# run other local tests except partial update
foreach ($tspFile in (Get-Item ./tsp/* -Filter "*.tsp" -Exclude "*partialupdate*")) {
  generate $tspFile
}

# partial update test
npx tsp compile ./tsp/partialupdate.tsp --options="@azure-tools/typespec-java.emitter-output-dir={project-root}/existingcode"
Copy-Item -Path ./existingcode/src/main/java/com/cadl/partialupdate -Destination ./src/main/java/com/cadl/ -Recurse -Force
Remove-Item ./existingcode -Recurse -Force

# run cadl ranch tests sources
Copy-Item -Path node_modules/@azure-tools/cadl-ranch-specs/http -Destination ./ -Recurse -Force

foreach ($tspFile in (Get-ChildItem ./http -Include "main.tsp","old.tsp" -File -Name -Recurse)) {
  Write-Host $tspFile
  generate "./http/$tspFile"
}
Remove-Item ./http -Recurse -Force
