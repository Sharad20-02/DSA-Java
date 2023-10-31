package Backtracking;

public class maximum_score {
    public static void main(String[] args) {

        int noOfWords = 4;
        String[] words = new String[noOfWords];
        words[0] = "dog";
        words[1] = "cat";
        words[2] = "dad";
        words[3] = "good";

        int noOfLetters = 9;
        char[] letters = new char[noOfLetters];
        letters[0] = 'a';
        letters[1] = 'b';
        letters[2] = 'c';
        letters[3] = 'd';
        letters[4] = 'd';
        letters[5] = 'd';
        letters[6] = 'g';
        letters[7] = 'o';
        letters[8] = 'o';

        // score = [1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0]
        int[] score = new int[26];
        score[0] = 1;
        score[1] = 0;
        score[2] = 9;
        score[3] = 5;
        score[4] = 0;
        score[5] = 0;
        score[6] = 3;
        for(int i=7; i<26; i++){
            score[i] = 0;
            if(i == 14){
                score[i] = 2;
            }
        }

        if(words == null || words.length == 0 || letters == null || letters.length == 0 || score.length == 0){
            System.out.println(0);
            return;
        }

        int[] farr = new int[score.length];
        for(char ch : letters){
            farr[ch - 'a'] ++;
        }
        int res = solution(words, farr, score, 0);
        System.out.println("Result is : " + res);
    }

    public static int solution(String[] words, int[] farr, int[] score, int idx){
        if(idx == words.length){
            return 0;
        }
        int sno = 0 + solution(words, farr, score, idx+1); // not included
        // include
        int sword = 0;
        String word = words[idx];
        boolean flag = true;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(farr[ch - 'a'] == 0){
                flag = false;
            }
            farr[ch - 'a']--;
            sword += score[ch - 'a'];
        }
        int syes = 0;
        if(flag){
            syes = sword + solution(words, farr, score, idx+1);
        }

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }
        return Math.max(sno, syes);
    }
}
