import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.util.UUID;

public class UUIDGenerator {
    public static void main(String[] args) {
        String printUUID = UUID.randomUUID().toString();
        System.out.println(printUUID);
    }
}
