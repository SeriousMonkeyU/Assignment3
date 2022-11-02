import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import sdj3.assignment3_1.protobuf.RequestText;
import sdj3.assignment3_1.protobuf.ResponseText;
import sdj3.assignment3_1.protobuf.RetrieveInfoGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8686)
                .usePlaintext()
                .build();

        RetrieveInfoGrpc.RetrieveInfoBlockingStub stub
                = RetrieveInfoGrpc.newBlockingStub(channel);

        ResponseText responseText = stub.retrievePackage(RequestText.newBuilder()
                .setInputText("1")
                .build());

        ResponseText responseText1 = stub.retrieveRegNum(RequestText.newBuilder()
                .setInputText("21")
                .build());

        System.out.println(responseText.getOutputText());
        System.out.println(responseText1.getOutputText());

        channel.shutdown();
    }
}
