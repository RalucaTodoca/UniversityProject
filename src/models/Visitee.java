package models;

import services.BookStatistics;

public interface Visitee {
    <T> T accept(Visitor<T> visitor);
}
