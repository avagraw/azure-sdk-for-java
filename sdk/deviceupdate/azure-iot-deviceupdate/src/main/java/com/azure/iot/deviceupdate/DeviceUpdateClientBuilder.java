// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.iot.deviceupdate;

import com.azure.core.annotation.ServiceClientBuilder;
import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.policy.CookiePolicy;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.policy.HttpPolicyProviders;
import com.azure.core.http.policy.RetryPolicy;
import com.azure.core.http.policy.UserAgentPolicy;
import com.azure.core.util.Configuration;
import com.azure.core.util.serializer.JacksonAdapter;
import com.azure.core.util.serializer.SerializerAdapter;
import com.azure.iot.deviceupdate.implementation.DeviceUpdateClientImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A builder for creating a new instance of the DeviceUpdateClient type. */
@ServiceClientBuilder(
        serviceClients = {
            UpdatesClient.class,
            DevicesClient.class,
            DeploymentsClient.class,
            UpdatesAsyncClient.class,
            DevicesAsyncClient.class,
            DeploymentsAsyncClient.class
        })
public final class DeviceUpdateClientBuilder {
    private static final String SDK_NAME = "name";

    private static final String SDK_VERSION = "version";

    private final Map<String, String> properties = new HashMap<>();

    /** Create an instance of the DeviceUpdateClientBuilder. */
    public DeviceUpdateClientBuilder() {
        this.pipelinePolicies = new ArrayList<>();
    }

    /*
     * Account endpoint.
     */
    private String accountEndpoint;

    /**
     * Sets Account endpoint.
     *
     * @param accountEndpoint the accountEndpoint value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder accountEndpoint(String accountEndpoint) {
        this.accountEndpoint = accountEndpoint;
        return this;
    }

    /*
     * Account instance identifier.
     */
    private String instanceId;

    /**
     * Sets Account instance identifier.
     *
     * @param instanceId the instanceId value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder instanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    /*
     * The HTTP pipeline to send requests through
     */
    private HttpPipeline pipeline;

    /**
     * Sets The HTTP pipeline to send requests through.
     *
     * @param pipeline the pipeline value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder pipeline(HttpPipeline pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    /*
     * The serializer to serialize an object into a string
     */
    private SerializerAdapter serializerAdapter;

    /**
     * Sets The serializer to serialize an object into a string.
     *
     * @param serializerAdapter the serializerAdapter value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder serializerAdapter(SerializerAdapter serializerAdapter) {
        this.serializerAdapter = serializerAdapter;
        return this;
    }

    /*
     * The HTTP client used to send the request.
     */
    private HttpClient httpClient;

    /**
     * Sets The HTTP client used to send the request.
     *
     * @param httpClient the httpClient value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder httpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /*
     * The configuration store that is used during construction of the service
     * client.
     */
    private Configuration configuration;

    /**
     * Sets The configuration store that is used during construction of the service client.
     *
     * @param configuration the configuration value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder configuration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    /*
     * The logging configuration for HTTP requests and responses.
     */
    private HttpLogOptions httpLogOptions;

    /**
     * Sets The logging configuration for HTTP requests and responses.
     *
     * @param httpLogOptions the httpLogOptions value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder httpLogOptions(HttpLogOptions httpLogOptions) {
        this.httpLogOptions = httpLogOptions;
        return this;
    }

    /*
     * The retry policy that will attempt to retry failed requests, if
     * applicable.
     */
    private RetryPolicy retryPolicy;

    /**
     * Sets The retry policy that will attempt to retry failed requests, if applicable.
     *
     * @param retryPolicy the retryPolicy value.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder retryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
        return this;
    }

    /*
     * The list of Http pipeline policies to add.
     */
    private final List<HttpPipelinePolicy> pipelinePolicies;

    /**
     * Adds a custom Http pipeline policy.
     *
     * @param customPolicy The custom Http pipeline policy to add.
     * @return the DeviceUpdateClientBuilder.
     */
    public DeviceUpdateClientBuilder addPolicy(HttpPipelinePolicy customPolicy) {
        pipelinePolicies.add(customPolicy);
        return this;
    }

    /**
     * Builds an instance of DeviceUpdateClientImpl with the provided parameters.
     *
     * @return an instance of DeviceUpdateClientImpl.
     */
    private DeviceUpdateClientImpl buildInnerClient() {
        if (pipeline == null) {
            this.pipeline = createHttpPipeline();
        }
        if (serializerAdapter == null) {
            this.serializerAdapter = JacksonAdapter.createDefaultSerializerAdapter();
        }
        DeviceUpdateClientImpl client =
                new DeviceUpdateClientImpl(pipeline, serializerAdapter, accountEndpoint, instanceId);
        return client;
    }

    private HttpPipeline createHttpPipeline() {
        Configuration buildConfiguration =
                (configuration == null) ? Configuration.getGlobalConfiguration() : configuration;
        if (httpLogOptions == null) {
            httpLogOptions = new HttpLogOptions();
        }
        List<HttpPipelinePolicy> policies = new ArrayList<>();
        String clientName = properties.getOrDefault(SDK_NAME, "UnknownName");
        String clientVersion = properties.getOrDefault(SDK_VERSION, "UnknownVersion");
        policies.add(
                new UserAgentPolicy(httpLogOptions.getApplicationId(), clientName, clientVersion, buildConfiguration));
        HttpPolicyProviders.addBeforeRetryPolicies(policies);
        policies.add(retryPolicy == null ? new RetryPolicy() : retryPolicy);
        policies.add(new CookiePolicy());
        policies.addAll(this.pipelinePolicies);
        HttpPolicyProviders.addAfterRetryPolicies(policies);
        policies.add(new HttpLoggingPolicy(httpLogOptions));
        HttpPipeline httpPipeline =
                new HttpPipelineBuilder()
                        .policies(policies.toArray(new HttpPipelinePolicy[0]))
                        .httpClient(httpClient)
                        .build();
        return httpPipeline;
    }

    /**
     * Builds an instance of UpdatesAsyncClient async client.
     *
     * @return an instance of UpdatesAsyncClient.
     */
    public UpdatesAsyncClient buildUpdatesAsyncClient() {
        return new UpdatesAsyncClient(buildInnerClient().getUpdates());
    }

    /**
     * Builds an instance of DevicesAsyncClient async client.
     *
     * @return an instance of DevicesAsyncClient.
     */
    public DevicesAsyncClient buildDevicesAsyncClient() {
        return new DevicesAsyncClient(buildInnerClient().getDevices());
    }

    /**
     * Builds an instance of DeploymentsAsyncClient async client.
     *
     * @return an instance of DeploymentsAsyncClient.
     */
    public DeploymentsAsyncClient buildDeploymentsAsyncClient() {
        return new DeploymentsAsyncClient(buildInnerClient().getDeployments());
    }

    /**
     * Builds an instance of UpdatesClient sync client.
     *
     * @return an instance of UpdatesClient.
     */
    public UpdatesClient buildUpdatesClient() {
        return new UpdatesClient(buildInnerClient().getUpdates());
    }

    /**
     * Builds an instance of DevicesClient sync client.
     *
     * @return an instance of DevicesClient.
     */
    public DevicesClient buildDevicesClient() {
        return new DevicesClient(buildInnerClient().getDevices());
    }

    /**
     * Builds an instance of DeploymentsClient sync client.
     *
     * @return an instance of DeploymentsClient.
     */
    public DeploymentsClient buildDeploymentsClient() {
        return new DeploymentsClient(buildInnerClient().getDeployments());
    }
}