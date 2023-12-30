import java.util.UUID;

public class test {

	    public static int generateUniqueId() {
	        UUID uuid = UUID.randomUUID();
	        long mostSignificantBits = uuid.getMostSignificantBits();
	        int uniqueId = (int) mostSignificantBits;
	        
	        uniqueId = Math.abs(uniqueId);
	        
	        return uniqueId;
	    }
	    public static void main(String[] args) {
	        int uniqueId = generateUniqueId();
	        System.out.println("Unique ID: " + uniqueId);
	    }

}
