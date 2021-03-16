package array.A1160find_words_that_can_be_formed_by_characters;

import java.util.HashMap;

/**
 * @Auther: 行路
 * @Date: Created on 2021/3/16 20:24 星期二
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 * @Description: array.A1160find_words_that_can_be_formed_by_characters  leetCode 1160.拼写单词
 * @version: 1.0
 */
public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[] words={"cat","bt","hat","tree"};
        String chars="atach";

        System.out.println(countCharacters(words,chars));

    }

    /**
     * 比较每个字母单词出现的次数和词汇表中的次数
     * @param words
     * @param chars
     * @return
     */
    public static int countCharacters(String[] words, String chars) {

        HashMap<Character, Integer> charsCnt = new HashMap<>();
        int length=chars.length();
        for(int i=0;i<length;i++){
            char c=chars.charAt(i);
            charsCnt.put(c,charsCnt.getOrDefault(c,0)+1);
        }

        int ans=0;

        for(String word:words){
            HashMap<Character, Integer> wordsCnt = new HashMap<>();
            int wordLength=word.length();
            for(int i=0;i<wordLength;i++){
                char c=word.charAt(i);
                wordsCnt.put(c,wordsCnt.getOrDefault(c,0)+1);
            }

            boolean isAns=true;

            for(int i=0;i<wordLength;i++){
                char c=word.charAt(i);
                if(charsCnt.getOrDefault(c,0)<wordsCnt.getOrDefault(c,0)){
                    isAns=false;
                    break;
                }
            }

            if(isAns){
                ans+=word.length();
            }


        }


        return  ans;
    }


    /**
     * 利用桶的思想
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters2(String[] words, String chars) {

            int[] chars_count = count(chars); // 统计字母表的字母出现次数
            int res = 0;
            for (String word : words) {
                int[] word_count = count(word); // 统计单词的字母出现次数
                if (contains(chars_count, word_count)) {
                    res += word.length();
                }
            }
            return res;
        }

        // 检查字母表的字母出现次数是否覆盖单词的字母出现次数
        boolean contains(int[] chars_count, int[] word_count) {
            for (int i = 0; i < 26; i++) {
                if (chars_count[i] < word_count[i]) {
                    return false;
                }
            }
            return true;
        }

        // 统计 26 个字母出现的次数
        int[] count(String word) {
            int[] counter = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                counter[c-'a']++;
            }
            return counter;
        }
}
