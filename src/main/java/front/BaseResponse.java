package front;

abstract public class BaseResponse {

    public static void response(Boolean status){
        if (status)
            System.out.println("operation completed successfully");
        else
            System.out.println("operation is not completed successfully");
    }
}
