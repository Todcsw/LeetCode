#### [1160. 拼写单词](https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/)



给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。

 

示例 1：

```
输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释： 
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
```


示例 2：

```
输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
```


提示：

```
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
所有字符串中都仅包含小写英文字母
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 解法一:比较每个字母单词出现的次数和词汇表中的次数

```java
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
```



### 解法二：利用桶的思想

```java
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
```

