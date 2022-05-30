package services;

import models.Book;

public class DocumentManager {
    private static DocumentManager instance_ = null;
    public Book book_;

    private DocumentManager()
    {

    }

    public static DocumentManager getInstance()
    {
        if (instance_ == null)
        {
            instance_ = new DocumentManager();
        }

        return instance_;
    }

    public Book getBook()
    {
        return book_;
    }

    public void setBook(Book book)
    {
        book_ = new Book(book);
    }
}
