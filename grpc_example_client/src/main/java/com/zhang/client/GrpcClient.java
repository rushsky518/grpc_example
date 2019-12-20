package com.zhang.client;

import com.zhang.HelloRequest;
import com.zhang.HelloResponse;
import com.zhang.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest req = HelloRequest.newBuilder()
                .setFirstName("zhang")
                .setLastName("gongzi")
                .build();

        HelloResponse resp = stub.hello(req);
        System.out.println(resp.getGreeting());

        channel.shutdown();
    }
}