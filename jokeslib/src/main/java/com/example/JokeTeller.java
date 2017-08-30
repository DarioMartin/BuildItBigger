package com.example;

import java.util.ArrayList;
import java.util.Random;

public class JokeTeller {

    private ArrayList<String> jokes = new ArrayList<>();

    public JokeTeller() {
        jokes.add("A computer lets you make more mistakes faster than any invention in human history – with the possible exceptions of handguns and tequila.");
        jokes.add("If it weren’t for C, we’d all be programming in BASI and OBOL.");
        jokes.add("There are 10 types of people in the world: those who understand binary, and those who don’t.");
        jokes.add("In a world without fences and walls, who needs Gates and Windows?");
        jokes.add("Programming today is a race between software engineers striving to build bigger and better idiot-proof programs, and the Universe trying to produce bigger and better idiots. So far, the Universe is winning.");
        jokes.add("Computers make very fast, very accurate mistakes.");
        jokes.add("Never underestimate the bandwidth of a station wagon full of tapes hurling down the highway.");
        jokes.add("An SQL statement walks into a bar and sees two tables. It approaches, and asks “may I join you?”");
        jokes.add("Q: Why is it that programmers always confuse Halloween with Christmas?\n" +
                "A: Because 31 OCT = 25 DEC.");
        jokes.add("Man is the best computer we can put aboard a spacecraft… and the only one that can be mass produced with unskilled labor");
        jokes.add("Q: How many programmers does it take to change a light bulb?\n" +
                "A: None. It’s a hardware problem.");
        jokes.add("Two strings walk into a bar and sit down. The bartender says, “So what’ll it be?”\n" +
                "The first string says, “I think I’ll have a beer quag fulk boorg jdk^CjfdLk jk3s d#f67howe%^U r89nvy~~owmc63^Dz x.xvcu”\n" +
                "“Please excuse my friend,” the second string says. “He isn’t null-terminated.”");
        jokes.add("“I’m not interrupting you, I’m putting our conversation in full-duplex mode.”\n" +
                "– Antone Roundy");
        jokes.add("A doctor, a civil engineer and a programmer are discussing whose profession is the oldest.\n" +
                "“Surely medicine is the oldest profession,” says the doctor. “God took a rib from Adam and created Eve and if this isn’t medicine I’ll be…”\n" +
                "The civil engineer breaks in:\n" +
                "“But before that He created the heavens and the earth from chaos. Now that’s civil engineering to me.”\n" +
                "The programmer thinks a bit and then says:\n" +
                "“And who do you think created chaos?”");
        jokes.add("A logician tells a colleague his wife just had a baby.\n" +
                "– Is it a boy or a girl?\n" +
                "– Yes.");
        jokes.add("A cop pulls over Werner Heisenberg and says, “Sir, do you know how fast you were going?”\n" +
                "Heisenberg responds, “NO, but I know EXACTLY where I am.”");
        jokes.add("Lotteries are a tax on people who suck at math.");
        jokes.add("Q: What does a proud computer call his little son? \n" +
                "A: A microchip off the old block. \n");
        jokes.add("Q: What is another name for a computer virus? \n" +
                "A: A terminal illness");
        jokes.add("Q: What do you get if you take your computer to an ice rink? \n" +
                "A: A slipped disk");
        jokes.add("Q: How can you tell if a computer geek is an extrovert? \n" +
                "A: They stare at your shoes when you talk instead of their own.");
        jokes.add("Q: Why did the programmer use the entire bottle of shampoo during one shower? \n" +
                "A: Because the bottle said \"Lather, Rinse, Repeat.\"");
        jokes.add("Q: How does a network administrator nerd greet people who come to his house? \n" +
                "A: Welcome to 127.0.0.1 ");
        jokes.add("Q: Why can't cats work on the computer? \n" +
                "A: They get too distracted chasing the mouse around.");
        jokes.add("Windows Vista supports real multitasking - it can boot and crash simultaneously.");
        jokes.add("The box said 'Requires Windows 95 or better'. So I installed Linux.");
    }

    public String getRandomJoke() {
        Random random = new Random(System.currentTimeMillis());
        return jokes.get(random.nextInt(jokes.size()));
    }
}
