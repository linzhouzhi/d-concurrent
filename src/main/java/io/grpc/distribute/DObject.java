// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: d-concurrent.proto

package io.grpc.distribute;

/**
 * Protobuf type {@code dconcurrent.DObject}
 */
public  final class DObject extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dconcurrent.DObject)
    DObjectOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DObject.newBuilder() to construct.
  private DObject(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DObject() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DObject(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 26: {
            com.google.protobuf.Any.Builder subBuilder = null;
            if (message_ != null) {
              subBuilder = message_.toBuilder();
            }
            message_ = input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(message_);
              message_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.distribute.DConcurrent.internal_static_dconcurrent_DObject_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.distribute.DConcurrent.internal_static_dconcurrent_DObject_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.distribute.DObject.class, io.grpc.distribute.DObject.Builder.class);
  }

  public static final int MESSAGE_FIELD_NUMBER = 3;
  private com.google.protobuf.Any message_;
  /**
   * <code>.google.protobuf.Any message = 3;</code>
   */
  public boolean hasMessage() {
    return message_ != null;
  }
  /**
   * <code>.google.protobuf.Any message = 3;</code>
   */
  public com.google.protobuf.Any getMessage() {
    return message_ == null ? com.google.protobuf.Any.getDefaultInstance() : message_;
  }
  /**
   * <code>.google.protobuf.Any message = 3;</code>
   */
  public com.google.protobuf.AnyOrBuilder getMessageOrBuilder() {
    return getMessage();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (message_ != null) {
      output.writeMessage(3, getMessage());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (message_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getMessage());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.distribute.DObject)) {
      return super.equals(obj);
    }
    io.grpc.distribute.DObject other = (io.grpc.distribute.DObject) obj;

    boolean result = true;
    result = result && (hasMessage() == other.hasMessage());
    if (hasMessage()) {
      result = result && getMessage()
          .equals(other.getMessage());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasMessage()) {
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.distribute.DObject parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.distribute.DObject parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.distribute.DObject parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.distribute.DObject parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.distribute.DObject parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.distribute.DObject parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.distribute.DObject parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.distribute.DObject parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.distribute.DObject parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.grpc.distribute.DObject parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.distribute.DObject parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.distribute.DObject parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.distribute.DObject prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code dconcurrent.DObject}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dconcurrent.DObject)
      io.grpc.distribute.DObjectOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.distribute.DConcurrent.internal_static_dconcurrent_DObject_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.distribute.DConcurrent.internal_static_dconcurrent_DObject_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.distribute.DObject.class, io.grpc.distribute.DObject.Builder.class);
    }

    // Construct using io.grpc.distribute.DObject.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (messageBuilder_ == null) {
        message_ = null;
      } else {
        message_ = null;
        messageBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.distribute.DConcurrent.internal_static_dconcurrent_DObject_descriptor;
    }

    public io.grpc.distribute.DObject getDefaultInstanceForType() {
      return io.grpc.distribute.DObject.getDefaultInstance();
    }

    public io.grpc.distribute.DObject build() {
      io.grpc.distribute.DObject result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public io.grpc.distribute.DObject buildPartial() {
      io.grpc.distribute.DObject result = new io.grpc.distribute.DObject(this);
      if (messageBuilder_ == null) {
        result.message_ = message_;
      } else {
        result.message_ = messageBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.distribute.DObject) {
        return mergeFrom((io.grpc.distribute.DObject)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.distribute.DObject other) {
      if (other == io.grpc.distribute.DObject.getDefaultInstance()) return this;
      if (other.hasMessage()) {
        mergeMessage(other.getMessage());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.grpc.distribute.DObject parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.grpc.distribute.DObject) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.Any message_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> messageBuilder_;
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public boolean hasMessage() {
      return messageBuilder_ != null || message_ != null;
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public com.google.protobuf.Any getMessage() {
      if (messageBuilder_ == null) {
        return message_ == null ? com.google.protobuf.Any.getDefaultInstance() : message_;
      } else {
        return messageBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder setMessage(com.google.protobuf.Any value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        message_ = value;
        onChanged();
      } else {
        messageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder setMessage(
        com.google.protobuf.Any.Builder builderForValue) {
      if (messageBuilder_ == null) {
        message_ = builderForValue.build();
        onChanged();
      } else {
        messageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder mergeMessage(com.google.protobuf.Any value) {
      if (messageBuilder_ == null) {
        if (message_ != null) {
          message_ =
            com.google.protobuf.Any.newBuilder(message_).mergeFrom(value).buildPartial();
        } else {
          message_ = value;
        }
        onChanged();
      } else {
        messageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public Builder clearMessage() {
      if (messageBuilder_ == null) {
        message_ = null;
        onChanged();
      } else {
        message_ = null;
        messageBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public com.google.protobuf.Any.Builder getMessageBuilder() {
      
      onChanged();
      return getMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    public com.google.protobuf.AnyOrBuilder getMessageOrBuilder() {
      if (messageBuilder_ != null) {
        return messageBuilder_.getMessageOrBuilder();
      } else {
        return message_ == null ?
            com.google.protobuf.Any.getDefaultInstance() : message_;
      }
    }
    /**
     * <code>.google.protobuf.Any message = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> 
        getMessageFieldBuilder() {
      if (messageBuilder_ == null) {
        messageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
                getMessage(),
                getParentForChildren(),
                isClean());
        message_ = null;
      }
      return messageBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:dconcurrent.DObject)
  }

  // @@protoc_insertion_point(class_scope:dconcurrent.DObject)
  private static final io.grpc.distribute.DObject DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.distribute.DObject();
  }

  public static io.grpc.distribute.DObject getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DObject>
      PARSER = new com.google.protobuf.AbstractParser<DObject>() {
    public DObject parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DObject(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DObject> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DObject> getParserForType() {
    return PARSER;
  }

  public io.grpc.distribute.DObject getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
