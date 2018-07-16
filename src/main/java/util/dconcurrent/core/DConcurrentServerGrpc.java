package util.dconcurrent.core;

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
  @java.lang.Deprecated // Use {@link #getResetStatMethod()} instead. 
  public static final io.grpc.MethodDescriptor<util.dconcurrent.core.DStatus,
      util.dconcurrent.core.DBytes> METHOD_RESET_STAT = getResetStatMethodHelper();

  private static volatile io.grpc.MethodDescriptor<util.dconcurrent.core.DStatus,
      util.dconcurrent.core.DBytes> getResetStatMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<util.dconcurrent.core.DStatus,
      util.dconcurrent.core.DBytes> getResetStatMethod() {
    return getResetStatMethodHelper();
  }

  private static io.grpc.MethodDescriptor<util.dconcurrent.core.DStatus,
      util.dconcurrent.core.DBytes> getResetStatMethodHelper() {
    io.grpc.MethodDescriptor<util.dconcurrent.core.DStatus, util.dconcurrent.core.DBytes> getResetStatMethod;
    if ((getResetStatMethod = DConcurrentServerGrpc.getResetStatMethod) == null) {
      synchronized (DConcurrentServerGrpc.class) {
        if ((getResetStatMethod = DConcurrentServerGrpc.getResetStatMethod) == null) {
          DConcurrentServerGrpc.getResetStatMethod = getResetStatMethod = 
              io.grpc.MethodDescriptor.<util.dconcurrent.core.DStatus, util.dconcurrent.core.DBytes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dconcurrent.DConcurrentServer", "ResetStat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DBytes.getDefaultInstance()))
                  .setSchemaDescriptor(new DConcurrentServerMethodDescriptorSupplier("ResetStat"))
                  .build();
          }
        }
     }
     return getResetStatMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStatMethod()} instead. 
  public static final io.grpc.MethodDescriptor<util.dconcurrent.core.DBytes,
      util.dconcurrent.core.DStatus> METHOD_GET_STAT = getGetStatMethodHelper();

  private static volatile io.grpc.MethodDescriptor<util.dconcurrent.core.DBytes,
      util.dconcurrent.core.DStatus> getGetStatMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<util.dconcurrent.core.DBytes,
      util.dconcurrent.core.DStatus> getGetStatMethod() {
    return getGetStatMethodHelper();
  }

  private static io.grpc.MethodDescriptor<util.dconcurrent.core.DBytes,
      util.dconcurrent.core.DStatus> getGetStatMethodHelper() {
    io.grpc.MethodDescriptor<util.dconcurrent.core.DBytes, util.dconcurrent.core.DStatus> getGetStatMethod;
    if ((getGetStatMethod = DConcurrentServerGrpc.getGetStatMethod) == null) {
      synchronized (DConcurrentServerGrpc.class) {
        if ((getGetStatMethod = DConcurrentServerGrpc.getGetStatMethod) == null) {
          DConcurrentServerGrpc.getGetStatMethod = getGetStatMethod = 
              io.grpc.MethodDescriptor.<util.dconcurrent.core.DBytes, util.dconcurrent.core.DStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dconcurrent.DConcurrentServer", "GetStat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DBytes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new DConcurrentServerMethodDescriptorSupplier("GetStat"))
                  .build();
          }
        }
     }
     return getGetStatMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunMethod()} instead. 
  public static final io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> METHOD_RUN = getRunMethodHelper();

  private static volatile io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> getRunMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> getRunMethod() {
    return getRunMethodHelper();
  }

  private static io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> getRunMethodHelper() {
    io.grpc.MethodDescriptor<util.dconcurrent.core.DObject, util.dconcurrent.core.DBytes> getRunMethod;
    if ((getRunMethod = DConcurrentServerGrpc.getRunMethod) == null) {
      synchronized (DConcurrentServerGrpc.class) {
        if ((getRunMethod = DConcurrentServerGrpc.getRunMethod) == null) {
          DConcurrentServerGrpc.getRunMethod = getRunMethod = 
              io.grpc.MethodDescriptor.<util.dconcurrent.core.DObject, util.dconcurrent.core.DBytes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dconcurrent.DConcurrentServer", "Run"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DBytes.getDefaultInstance()))
                  .setSchemaDescriptor(new DConcurrentServerMethodDescriptorSupplier("Run"))
                  .build();
          }
        }
     }
     return getRunMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCallMethod()} instead. 
  public static final io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> METHOD_CALL = getCallMethodHelper();

  private static volatile io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> getCallMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> getCallMethod() {
    return getCallMethodHelper();
  }

  private static io.grpc.MethodDescriptor<util.dconcurrent.core.DObject,
      util.dconcurrent.core.DBytes> getCallMethodHelper() {
    io.grpc.MethodDescriptor<util.dconcurrent.core.DObject, util.dconcurrent.core.DBytes> getCallMethod;
    if ((getCallMethod = DConcurrentServerGrpc.getCallMethod) == null) {
      synchronized (DConcurrentServerGrpc.class) {
        if ((getCallMethod = DConcurrentServerGrpc.getCallMethod) == null) {
          DConcurrentServerGrpc.getCallMethod = getCallMethod = 
              io.grpc.MethodDescriptor.<util.dconcurrent.core.DObject, util.dconcurrent.core.DBytes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dconcurrent.DConcurrentServer", "Call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  util.dconcurrent.core.DBytes.getDefaultInstance()))
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
    public void resetStat(util.dconcurrent.core.DStatus request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes> responseObserver) {
      asyncUnimplementedUnaryCall(getResetStatMethodHelper(), responseObserver);
    }

    /**
     */
    public void getStat(util.dconcurrent.core.DBytes request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStatMethodHelper(), responseObserver);
    }

    /**
     */
    public void run(util.dconcurrent.core.DObject request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes> responseObserver) {
      asyncUnimplementedUnaryCall(getRunMethodHelper(), responseObserver);
    }

    /**
     */
    public void call(util.dconcurrent.core.DObject request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes> responseObserver) {
      asyncUnimplementedUnaryCall(getCallMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getResetStatMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                util.dconcurrent.core.DStatus,
                util.dconcurrent.core.DBytes>(
                  this, METHODID_RESET_STAT)))
          .addMethod(
            getGetStatMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                util.dconcurrent.core.DBytes,
                util.dconcurrent.core.DStatus>(
                  this, METHODID_GET_STAT)))
          .addMethod(
            getRunMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                util.dconcurrent.core.DObject,
                util.dconcurrent.core.DBytes>(
                  this, METHODID_RUN)))
          .addMethod(
            getCallMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                util.dconcurrent.core.DObject,
                util.dconcurrent.core.DBytes>(
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
    public void resetStat(util.dconcurrent.core.DStatus request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getResetStatMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStat(util.dconcurrent.core.DBytes request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStatMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void run(util.dconcurrent.core.DObject request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void call(util.dconcurrent.core.DObject request,
        io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes> responseObserver) {
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
    public util.dconcurrent.core.DBytes resetStat(util.dconcurrent.core.DStatus request) {
      return blockingUnaryCall(
          getChannel(), getResetStatMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public util.dconcurrent.core.DStatus getStat(util.dconcurrent.core.DBytes request) {
      return blockingUnaryCall(
          getChannel(), getGetStatMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public util.dconcurrent.core.DBytes run(util.dconcurrent.core.DObject request) {
      return blockingUnaryCall(
          getChannel(), getRunMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public util.dconcurrent.core.DBytes call(util.dconcurrent.core.DObject request) {
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
    public com.google.common.util.concurrent.ListenableFuture<util.dconcurrent.core.DBytes> resetStat(
        util.dconcurrent.core.DStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getResetStatMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<util.dconcurrent.core.DStatus> getStat(
        util.dconcurrent.core.DBytes request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStatMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<util.dconcurrent.core.DBytes> run(
        util.dconcurrent.core.DObject request) {
      return futureUnaryCall(
          getChannel().newCall(getRunMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<util.dconcurrent.core.DBytes> call(
        util.dconcurrent.core.DObject request) {
      return futureUnaryCall(
          getChannel().newCall(getCallMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESET_STAT = 0;
  private static final int METHODID_GET_STAT = 1;
  private static final int METHODID_RUN = 2;
  private static final int METHODID_CALL = 3;

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
        case METHODID_RESET_STAT:
          serviceImpl.resetStat((util.dconcurrent.core.DStatus) request,
              (io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes>) responseObserver);
          break;
        case METHODID_GET_STAT:
          serviceImpl.getStat((util.dconcurrent.core.DBytes) request,
              (io.grpc.stub.StreamObserver<util.dconcurrent.core.DStatus>) responseObserver);
          break;
        case METHODID_RUN:
          serviceImpl.run((util.dconcurrent.core.DObject) request,
              (io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes>) responseObserver);
          break;
        case METHODID_CALL:
          serviceImpl.call((util.dconcurrent.core.DObject) request,
              (io.grpc.stub.StreamObserver<util.dconcurrent.core.DBytes>) responseObserver);
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
      return util.dconcurrent.core.DConcurrent.getDescriptor();
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
              .addMethod(getResetStatMethodHelper())
              .addMethod(getGetStatMethodHelper())
              .addMethod(getRunMethodHelper())
              .addMethod(getCallMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
