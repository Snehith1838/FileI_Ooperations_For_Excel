package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {
    public static void main(String[] args) {
        String filePath = "C:\\Project\\demolargetextfile.txt";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.write("Rohit Gurunath Sharma (born 30 April 1987) is an Indian international cricketer who currently plays for and captains the India national cricket team in Test and One Day International (ODI) matches.\n" + "Previously, he also captained the team in Twenty20 International (T20I) matches and led India's win in 2024 ICC Men's T20 World Cup, subsequent to which he retired from T20s in June 2024.[4][5]\n" + "The right-handed batsman, who is considered one of the best batsmen of his generation and one of the greatest opening batters of all time,[6] is known for his timing, elegance, six-hitting abilities and leadership skills.\n" +

            "He holds several batting records which famously include most runs in T20 Internationals, most sixes in international cricket,\n" + "[a] most double centuries in ODI cricket (3), most centuries at Cricket World Cups (7) and joint most hundreds in Twenty20 Internationals (5).\n" + "He is the first player to score 5 T20I centuries.[8] He also holds the world record for the highest individual score (264) in a One Day International (ODI) match and is the only player to have scored three double-centuries in ODIs and also holds the record for scoring most hundreds (five) in a single Cricket World Cup,\n" +"for which he won the ICC Men's ODI Cricketer of the Year award in 2019.\n" + "He is the only player to win 50 matches as captain in T20Is.[9]\n" +

            "He plays for Mumbai Indians and Mumbai cricket team in Indian Premier League (IPL) and domestic cricket respectively.\n" + "He formerly captained Mumbai Indians and the team has won 5 Indian Premier League titles in 2013, 2015, 2017, 2019 and 2020 under him, making him the most successful captain in IPL history, sharing this record with MS Dhoni.\n" + "With India, Rohit Sharma was a member of the team that won the 2007 T20 World Cup, and the 2013 ICC Champions Trophy, where he played in the finals of both tournaments.\n" + "He is also one of two players who have played in every edition of the T20 World Cup, from the inaugural edition in 2007 to the latest one in 2024.[b] He is the only Indian player to win two T20 World Cups./n" + "He became the second Indian captain to win a T20 World Cup, when he led India to win the 2024 T20 World Cup.\n" +

                    "He has received two national honours, the Arjuna Award in 2015 and the prestigious Major Dhyan Chand Khel Ratna Award in 2020 by the Government of India. Under his captaincy, India won the 2018 Asia Cup and the 2023 Asia Cup, the seventh and eighth time the country won the title, both in ODI format as well as the 2018 Nidahas Trophy, their second overall and first in T20I format.\n" +

                    "Outside cricket, Sharma is an active supporter of animal welfare campaigns. He is the official Rhino Ambassador for WWF-India and is a member of People for the Ethical Treatment of Animals (PETA).\n" + "He has worked with PETA in its campaign to raise awareness of the plight of homeless cats and dogs in India.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
