SOURCE = $(wildcard *.c)
OBJS = $(SOURCE:.c=.o)
HEADER = $(wildcard *.h)
TEXT = $(wildcard *.txt)
OUT = generate
ZIP = generate.zip
CC = gcc
CFLAGS = -ggdb -Wall -std=c99
LFLAGS = -lm

all: $(OBJS)
		$(CC) $(CFLAGS) $(OBJS) -o $(OUT) $(LFLAGS)

clean:
		rm -f $(OBJS) $(OUT) $(ZIP) $(DAT) $(TEXT)

zip:
		zip $(ZIP) $(HEADER) $(SOURCE) Makefile
