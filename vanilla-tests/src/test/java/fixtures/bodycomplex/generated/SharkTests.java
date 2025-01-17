// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package fixtures.bodycomplex.generated;

import com.azure.core.util.BinaryData;
import fixtures.bodycomplex.models.Fish;
import fixtures.bodycomplex.models.Shark;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class SharkTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        Shark model = BinaryData.fromString(
            "{\"fishtype\":\"shark\",\"age\":732372528,\"birthday\":\"2021-05-16T15:44:09Z\",\"species\":\"kao\",\"length\":63.108402,\"siblings\":[{\"fishtype\":\"Fish\",\"species\":\"tyhxhurokft\",\"length\":81.88607,\"siblings\":[{\"fishtype\":\"Fish\",\"species\":\"iwpwcuk\",\"length\":48.25244,\"siblings\":[{\"fishtype\":\"Fish\",\"length\":45.296448},{\"fishtype\":\"Fish\",\"length\":36.07977}]},{\"fishtype\":\"Fish\",\"species\":\"xklrypl\",\"length\":66.94554,\"siblings\":[{\"fishtype\":\"Fish\",\"length\":17.269373},{\"fishtype\":\"Fish\",\"length\":22.518778}]},{\"fishtype\":\"Fish\",\"species\":\"ypnddhsgcb\",\"length\":17.565834,\"siblings\":[{\"fishtype\":\"Fish\",\"length\":17.47195},{\"fishtype\":\"Fish\",\"length\":23.44771},{\"fishtype\":\"Fish\",\"length\":23.57843}]},{\"fishtype\":\"Fish\",\"species\":\"tynqgoul\",\"length\":30.246729,\"siblings\":[{\"fishtype\":\"Fish\",\"length\":5.8344603},{\"fishtype\":\"Fish\",\"length\":16.492962},{\"fishtype\":\"Fish\",\"length\":61.310524}]}]}]}")
            .toObject(Shark.class);
        Assertions.assertEquals("kao", model.getSpecies());
        Assertions.assertEquals(63.108402f, model.getLength());
        Assertions.assertEquals("tyhxhurokft", model.getSiblings().get(0).getSpecies());
        Assertions.assertEquals(81.88607f, model.getSiblings().get(0).getLength());
        Assertions.assertEquals("iwpwcuk", model.getSiblings().get(0).getSiblings().get(0).getSpecies());
        Assertions.assertEquals(48.25244f, model.getSiblings().get(0).getSiblings().get(0).getLength());
        Assertions.assertEquals(45.296448f,
            model.getSiblings().get(0).getSiblings().get(0).getSiblings().get(0).getLength());
        Assertions.assertEquals(732372528, model.getAge());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-16T15:44:09Z"), model.getBirthday());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        Shark model = new Shark(63.108402f, OffsetDateTime.parse("2021-05-16T15:44:09Z")).setSpecies("kao")
            .setSiblings(Arrays.asList(new Fish(81.88607f).setSpecies("tyhxhurokft")
                .setSiblings(Arrays.asList(
                    new Fish(48.25244f).setSpecies("iwpwcuk")
                        .setSiblings(Arrays.asList(new Fish(45.296448f), new Fish(36.07977f))),
                    new Fish(66.94554f).setSpecies("xklrypl")
                        .setSiblings(Arrays.asList(new Fish(17.269373f), new Fish(22.518778f))),
                    new Fish(17.565834f).setSpecies("ypnddhsgcb")
                        .setSiblings(Arrays.asList(new Fish(17.47195f), new Fish(23.44771f), new Fish(23.57843f))),
                    new Fish(30.246729f).setSpecies("tynqgoul").setSiblings(
                        Arrays.asList(new Fish(5.8344603f), new Fish(16.492962f), new Fish(61.310524f)))))))
            .setAge(732372528);
        model = BinaryData.fromObject(model).toObject(Shark.class);
        Assertions.assertEquals("kao", model.getSpecies());
        Assertions.assertEquals(63.108402f, model.getLength());
        Assertions.assertEquals("tyhxhurokft", model.getSiblings().get(0).getSpecies());
        Assertions.assertEquals(81.88607f, model.getSiblings().get(0).getLength());
        Assertions.assertEquals("iwpwcuk", model.getSiblings().get(0).getSiblings().get(0).getSpecies());
        Assertions.assertEquals(48.25244f, model.getSiblings().get(0).getSiblings().get(0).getLength());
        Assertions.assertEquals(45.296448f,
            model.getSiblings().get(0).getSiblings().get(0).getSiblings().get(0).getLength());
        Assertions.assertEquals(732372528, model.getAge());
        Assertions.assertEquals(OffsetDateTime.parse("2021-05-16T15:44:09Z"), model.getBirthday());
    }
}
