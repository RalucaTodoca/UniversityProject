package services;

import models.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCommand implements Command{
    private String file_;

    public OpenCommand(String file)
    {
        file_ = file;
    }

    @Override
    public void execute() {
        try {
            String jsonFileData = new String(Files.readAllBytes(Paths.get(file_)));
            JSONObject book = new JSONObject(jsonFileData);
            JSONArray bookElements = book.getJSONArray("elements");
            Book concreteBook = new Book("test");

            for (int i = 0; i < bookElements.length(); i++){
                JSONObject e = bookElements.getJSONObject(i);

                Iterator keys = e.keys();

                while (keys.hasNext())
                {
                    String currentKey = (String)keys.next();

                    JSONObject currentObj = e.getJSONObject(currentKey);

                    if (currentKey.equals("paragraph")){

                    }
                }
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}