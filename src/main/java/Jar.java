import java.util.Random;

public class Jar {

    private String mItemName;
    private int mMaxNum;
    private int mAnswer;

    public Jar() {
        mItemName = "";
        mMaxNum = 0;
    }

    public Jar(String itemName, int maxNum) {
        mItemName = itemName;
        mMaxNum = maxNum;
    }

    public void fillJar() {
        Random random = new Random();
        mAnswer = 1 + random.nextInt(getMaxItems());
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public void setMaxNum(int maxNum) {
        mMaxNum = maxNum;
    }

    public String getItemName() {
        return mItemName;
    }

    public int getMaxItems() {
        return mMaxNum;
    }

    public int getAnswer() {
        return mAnswer;
    }
}