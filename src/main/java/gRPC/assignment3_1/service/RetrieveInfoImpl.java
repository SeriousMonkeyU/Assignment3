package gRPC.assignment3_1.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import gRPC.assignment3_1.protobuf.RequestText;
import gRPC.assignment3_1.protobuf.ResponseText;
import gRPC.assignment3_1.protobuf.RetrieveInfoGrpc;

import java.util.ArrayList;

import static gRPC.assignment3_1.database.Retrieve.getPackages;
import static gRPC.assignment3_1.database.Retrieve.getRegNum;

@GRpcService
public class RetrieveInfoImpl extends RetrieveInfoGrpc.RetrieveInfoImplBase {
    @Override
    public void retrieveRegNum(RequestText request, StreamObserver<ResponseText> responseObserver) {
        System.out.println("\nReceived Request ===> " + request.toString());
        String tempRespond = "Product Nr. " + request.getInputText() + " has these animal parts ===> ";
        ArrayList<Integer> tempList = getRegNum(request.getInputText());
        tempRespond += tempList.get(0);
        for (int i = 1; i < tempList.size()-1; i++) {
            tempRespond += ", ";
            tempRespond += tempList.get(i);
        }
        tempRespond += ".";
        ResponseText responseText = ResponseText.newBuilder().setOutputText(tempRespond).build();
        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }


    @Override
    public void retrievePackage(RequestText request, StreamObserver<ResponseText> responseObserver) {
        System.out.println("\nReceived Request ===> " + request.toString());
        System.out.println("Launching retrieve function from database");
        String tempRespond = "Animal Nr. " + request.getInputText() + " is in these products ===> ";
        ArrayList<Integer> tempList = getPackages(request.getInputText());
        tempRespond += tempList.get(0);
        for (int i = 1; i < tempList.size()-1; i++) {
            tempRespond += ", ";
            tempRespond += tempList.get(i);
        }
        tempRespond += ".";
        System.out.println("The respond was generated ===> " + tempRespond);

        ResponseText responseText = ResponseText.newBuilder().setOutputText(tempRespond).build();
        System.out.println("The respond was sent!");

        responseObserver.onNext(responseText);
        responseObserver.onCompleted();
    }


}
