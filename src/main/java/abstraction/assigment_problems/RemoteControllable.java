package abstraction.assigment_problems;

public interface RemoteControllable {
    String connect(String appId);

    static void connectAll(RemoteControllable[] items, String appId) {
        if (items != null) {
            for (RemoteControllable item : items) {
                if (item != null) {
                    System.out.println(item.connect(appId));
                }
            }
        }
    }
}
