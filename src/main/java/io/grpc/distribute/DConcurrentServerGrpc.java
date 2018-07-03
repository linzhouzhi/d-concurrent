package io.grpc.distribute;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.10.0)",
        comments = "Source: d-concurrent.proto")
public final class DConcurrentServerGrpc {

  private DConcurrentServerGrpc() {}

  public static final String SERVICE_NAME = "dconcurrent.DConcurrentServer";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunMethod()} instead.
  public static final io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> METHOD_RUN = getRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> getRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> getRunMethod() {
    return getRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> getRunMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.distribute.DObject, io.grpc.distribute.DObject> getRunMethod;
    if ((getRunMethod = DConcurrentServerGrpc.getRunMethod) == null) {
      synchronized (DConcurrentServerGrpc.class) {
        if ((getRunMethod = DConcurrentServerGrpc.getRunMethod) == null) {
          DConcurrentServerGrpc.getRunMethod = getRunMethod =
                  io.grpc.MethodDescriptor.<io.grpc.distribute.DObject, io.grpc.distribute.DObject>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "dconcurrent.DConcurrentServer", "Run"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  io.grpc.distribute.DObject.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  io.grpc.distribute.DObject.getDefaultInstance()))
                          .setSchemaDescriptor(new DConcurrentServerMethodDescriptorSupplier("Run"))
                          .build();
        }
      }
    }
    return getRunMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCallMethod()} instead.
  public static final io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> METHOD_CALL = getCallMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> getCallMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> getCallMethod() {
    return getCallMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.distribute.DObject,
          io.grpc.distribute.DObject> getCallMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.distribute.DObject, io.grpc.distribute.DObject> getCallMethod;
    if ((getCallMethod = DConcurrentServerGrpc.getCallMethod) == null) {
      synchronized (DConcurrentServerGrpc.class) {
        if ((getCallMethod = DConcurrentServerGrpc.getCallMethod) == null) {
          DConcurrentServerGrpc.getCallMethod = getCallMethod =
                  io.grpc.MethodDescriptor.<io.grpc.distribute.DObject, io.grpc.distribute.DObject>newBuilder()
                          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                          .setFullMethodName(generateFullMethodName(
                                  "dconcurrent.DConcurrentServer", "Call"))
                          .setSampledToLocalTracing(true)
                          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  io.grpc.distribute.DObject.getDefaultInstance()))
                          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                  io.grpc.distribute.DObject.getDefaultInstance()))
                          .setSchemaDescriptor(new DConcurrentServerMethodDescriptorSupplier("Call"))
                          .build();
        }
      }
    }
    return getCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DConcurrentServerStub newStub(io.grpc.Channel channel) {
    return new DConcurrentServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DConcurrentServerBlockingStub newBlockingStub(
          io.grpc.Channel channel) {
    return new DConcurrentServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DConcurrentServerFutureStub newFutureStub(
          io.grpc.Channel channel) {
    return new DConcurrentServerFutureStub(channel);
  }

  /**
   */
  public static abstract class DConcurrentServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void run(io.grpc.distribute.DObject request,
                    io.grpc.stub.StreamObserver<io.grpc.distribute.DObject> responseObserver) {
      asyncUnimplementedUnaryCall(getRunMethodHelper(), responseObserver);
    }

    /**
     */
    public void call(io.grpc.distribute.DObject request,
                     io.grpc.stub.StreamObserver<io.grpc.distribute.DObject> responseObserver) {
      asyncUnimplementedUnaryCall(getCallMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
              .addMethod(
                      getRunMethodHelper(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      io.grpc.distribute.DObject,
                                      io.grpc.distribute.DObject>(
                                      this, METHODID_RUN)))
              .addMethod(
                      getCallMethodHelper(),
                      asyncUnaryCall(
                              new MethodHandlers<
                                      io.grpc.distribute.DObject,
                                      io.grpc.distribute.DObject>(
                                      this, METHODID_CALL)))
              .build();
    }
  }

  /**
   */
  public static final class DConcurrentServerStub extends io.grpc.stub.AbstractStub<DConcurrentServerStub> {
    private DConcurrentServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DConcurrentServerStub(io.grpc.Channel channel,
                                  io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DConcurrentServerStub build(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
      return new DConcurrentServerStub(channel, callOptions);
    }

    /**
     */
    public void run(io.grpc.distribute.DObject request,
                    io.grpc.stub.StreamObserver<io.grpc.distribute.DObject> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getRunMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void call(io.grpc.distribute.DObject request,
                     io.grpc.stub.StreamObserver<io.grpc.distribute.DObject> responseObserver) {
      asyncUnaryCall(
              getChannel().newCall(getCallMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DConcurrentServerBlockingStub extends io.grpc.stub.AbstractStub<DConcurrentServerBlockingStub> {
    private DConcurrentServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DConcurrentServerBlockingStub(io.grpc.Channel channel,
                                          io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DConcurrentServerBlockingStub build(io.grpc.Channel channel,
                                                  io.grpc.CallOptions callOptions) {
      return new DConcurrentServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.distribute.DObject run(io.grpc.distribute.DObject request) {
      return blockingUnaryCall(
              getChannel(), getRunMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.distribute.DObject call(io.grpc.distribute.DObject request) {
      return blockingUnaryCall(
              getChannel(), getCallMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DConcurrentServerFutureStub extends io.grpc.stub.AbstractStub<DConcurrentServerFutureStub> {
    private DConcurrentServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DConcurrentServerFutureStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DConcurrentServerFutureStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
      return new DConcurrentServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.distribute.DObject> run(
            io.grpc.distribute.DObject request) {
      return futureUnaryCall(
              getChannel().newCall(getRunMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.distribute.DObject> call(
            io.grpc.distribute.DObject request) {
      return futureUnaryCall(
              getChannel().newCall(getCallMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN = 0;
  private static final int METHODID_CALL = 1;

  private static final class MethodHandlers<Req, Resp> implements
          io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DConcurrentServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DConcurrentServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN:
          serviceImpl.run((io.grpc.distribute.DObject) request,
                  (io.grpc.stub.StreamObserver<io.grpc.distribute.DObject>) responseObserver);
          break;
        case METHODID_CALL:
          serviceImpl.call((io.grpc.distribute.DObject) request,
                  (io.grpc.stub.StreamObserver<io.grpc.distribute.DObject>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
            io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DConcurrentServerBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DConcurrentServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.distribute.DConcurrent.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DConcurrentServer");
    }
  }

  private static final class DConcurrentServerFileDescriptorSupplier
          extends DConcurrentServerBaseDescriptorSupplier {
    DConcurrentServerFileDescriptorSupplier() {}
  }

  private static final class DConcurrentServerMethodDescriptorSupplier
          extends DConcurrentServerBaseDescriptorSupplier
          implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DConcurrentServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DConcurrentServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                  .setSchemaDescriptor(new DConcurrentServerFileDescriptorSupplier())
                  .addMethod(getRunMethodHelper())
                  .addMethod(getCallMethodHelper())
                  .build();
        }
      }
    }
    return result;
  }
}
