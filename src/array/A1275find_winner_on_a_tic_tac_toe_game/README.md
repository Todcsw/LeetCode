#### [1275. 找出井字棋的获胜者](https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game/)

A 和 B 在一个 3 x 3 的网格上玩井字棋。

井字棋游戏的规则如下：

玩家轮流将棋子放在空方格 (" ") 上。
第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
"X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
如果所有方块都放满棋子（不为空），游戏也会结束。
游戏结束后，棋子无法再进行任何移动。
给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。

如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。

你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。

 

示例 1：

```
输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
输出："A"
解释："A" 获胜，他总是先走。
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"
```


示例 2：

```
输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
输出："B"
解释："B" 获胜。
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
"   "    "   "    "   "    "   "    "   "    "O  "
```


示例 3：

```
输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
输出："Draw"
输出：由于没有办法再行动，游戏以平局结束。
"XXO"
"OOX"
"XOX"
```


示例 4：

```
输入：moves = [[0,0],[1,1]]
输出："Pending"
解释：游戏还没有结束。
"X  "
" O "
"   "
```


提示：

```
1 <= moves.length <= 9
moves[i].length == 2
0 <= moves[i][j] <= 2
moves 里没有重复的元素。
moves 遵循井字棋的规则。
```

> 来源：力扣（LeetCode）
> 链接：https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game
> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。





### 解法一：

```java
    /**
     * 第一种解法
     * @param moves
     * @return
     */
    public static String tictactoe(int[][] moves) {
        boolean flag=true;

        int[][] nums=new int[3][3];

        for(int i=0;i<moves.length;i=i+2){
            nums[moves[i][0]][moves[i][1]]=1;
        }
        for(int i=1;i<moves.length;i+=2){
            nums[moves[i][0]][moves[i][1]]=-1;
        }

        if(nums[0][0]+nums[1][1]+nums[2][2]==3||nums[2][0]+nums[1][1]+nums[0][2]==3){
            return "A";
        }else if(nums[0][0]+nums[1][1]+nums[2][2]==-3||nums[2][0]+nums[1][1]+nums[0][2]==-3){
            return "B";
        }

        for(int i=0;i<nums.length;i++){

            int sum=0;
            int sum2=0;
            for(int j=0;j<nums[i].length;j++){

                if(flag!=false){
                    if(nums[i][j]==0){
                        flag=false;
                    }
                }
                sum+=nums[i][j];
                sum2+=nums[j][i];

            }
            if(sum==3||sum2==3){
                return "A";
            }else if(sum==-3||sum2==-3){
                return "B";
            }
        }

        if(flag==true){
            return "Draw";
        }else{
            return "Pending";
        }

    }
```



### 解法二：

```java
   /**
     * 第二种解法
     * @param moves
     * @return
     */
    public static String tictactoe2(int[][] moves) {

        int m = moves.length;
        // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
        // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
        int[] count = new int[8];
        // 思路第2步已解释为何只需考虑最后一个落棋的人
        // 倒序统计此人走棋情况
        for(int i = m - 1; i >= 0; i -= 2) {
            // 此棋对行的影响
            count[moves[i][0]]++;
            // 此棋对列的影响
            count[moves[i][1] + 3]++;
            // 此棋对正对角线的影响
            if(moves[i][0] == moves[i][1])
                count[6]++;
            // 此棋对副对角线的影响 (此处为3x3的情况，其余大小的棋盘可以类推)
            if(moves[i][0] + moves[i][1] == 2)
                count[7]++;
            // 满3个棋子则胜利
            if(count[moves[i][0]] == 3 || count[moves[i][1] + 3] == 3 ||
                    count[6] == 3 || count[7] == 3)
                // A先B后 则总长度为偶时 最后为B 反之为A
                return m % 2 == 0 ? "B" : "A";
        }
        // 未胜时，棋盘未下满则继续
        if(moves.length < 9)
            return "Pending";
        // 未胜时，棋盘下满则平局结束
        return "Draw";

    }

```

