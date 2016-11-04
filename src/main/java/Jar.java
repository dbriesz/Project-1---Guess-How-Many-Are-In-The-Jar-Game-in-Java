import java.util.Random;

public class Jar {

    private String mItemName;
    private int mMaxNum;
    private int mAnswer;

    public Jar(String itemName, int maxNum) {
        mItemName = itemName;
        mMaxNum = maxNum;
        Random random = new Random();
        mAnswer = 1 + random.nextInt(mMaxNum);
    }

    public String getItemName() { return mItemName; }

    public int getMaxItems() { return mMaxNum; }

    public int getAnswer() { return mAnswer; }
}