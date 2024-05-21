CREATE TABLE books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       releaseDate VARCHAR(255) NOT NULL,
                       isbn VARCHAR(20) NOT NULL
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        bookIds ARRAY,
                        userId VARCHAR(255) NOT NULL
);