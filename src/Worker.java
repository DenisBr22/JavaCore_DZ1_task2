public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }



    public void start() {
        for (int i = 1; i < 101; i++) {
            if (i == 33) {
                errorCallback.onError("Задача " + i + " закончилась ошибкой");
            } else {
                callback.onDone("Задача " + i + " выполнена");
            }
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String error);
    }
}
