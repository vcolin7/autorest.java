// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.autorest.fluent.model.clientmodel;

import com.azure.autorest.fluent.template.FluentExampleTemplate;

public class FluentExampleLiveTestStep extends FluentLiveTestStep {

    private FluentExampleTemplate.ExampleMethod exampleMethod;

    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder extends FluentLiveTestStep.Builder<FluentExampleLiveTestStep, Builder> {

        private Builder(){
            super(new FluentExampleLiveTestStep());
        }

        public Builder exampleMethod(FluentExampleTemplate.ExampleMethod exampleMethod) {
            getStep().exampleMethod = exampleMethod;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

    }

    public FluentExampleTemplate.ExampleMethod getExampleMethod() {
        return exampleMethod;
    }

}
