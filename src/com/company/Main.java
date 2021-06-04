package com.company;

import javax.management.monitor.GaugeMonitor;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int player = 3;
        int opponent = 3;
        Game(player, opponent);
    }

    public static void Game(int P, int O) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        if (P == 0) {
            System.out.println("Player is winner");
            return;
        }

        if (O == 0) {
            System.out.println("Bor is winner");
            return;
        }

        System.out.printf("Player 1, how much rocks do you want to take? (from 0 - %d) ", P);
        int p1 = scan.nextInt();
        System.out.print("How many rocks your opponent has taken? ");
        int p2 = scan.nextInt();

        int sum = p1 + p2;
        int bot1 = rand.nextInt(O);
        int bot;

        for (;;) {
            int bot2 = rand.nextInt(P);
            bot = bot2 + bot1;

            if (bot != sum) {
                break;
            }
        }

        if (p1 + bot1 == sum) {
            System.out.println("Player won round");
            Game(P-1, O);
        } else if (p1 + bot1 == bot) {
            System.out.println("Bot won round");
            Game(P, O-1);
        } else {
            System.out.println("Draw");
            Game(P,O);
        }
    }
}
