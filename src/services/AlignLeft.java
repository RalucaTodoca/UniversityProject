package services;

import models.Context;

public class AlignLeft implements AlignStrategy {
    public String render(String paragraph, Context context)
    {
        return paragraph;
    }
}