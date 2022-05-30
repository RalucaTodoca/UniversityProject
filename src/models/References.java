package models;

public class References {
    private boolean hasParent_ = false;

    public void setParent(boolean hasParent)
    {
        hasParent_ = hasParent;
    }

    public boolean getParent()
    {
        return hasParent_;
    }
}
