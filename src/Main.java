//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Solution {
    public String solution(int num) {
        String answer = "";
        answer = (num % 2 == 0) ? "Even" : "Odd";
        return answer;
    }
}