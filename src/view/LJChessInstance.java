package view;

public final class LJChessInstance {
  private static Object lock = new Object();
  private static LJChessInstance instance;
  private IMain main_listener;
  
  private LJChessInstance() {}
  
  public static LJChessInstance instance() {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new LJChessInstance();
        }
      }
    }
    return instance;
  }
  
  public void addListener(Object listener) {
    if (listener instanceof IMain) this.main_listener = listener;
  }
  
  public IMain getMainListener() {
    return main_listener;
  }
}
