package services;

import  models.Context;

public interface AlignStrategy {
    String render(String paragraph, Context context);
}
