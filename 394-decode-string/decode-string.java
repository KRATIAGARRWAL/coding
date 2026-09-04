class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stk = new Stack<>();
        int n = s.length();
        stk.push(new StringBuilder("" + s.charAt(0)));
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '[') {
                stk.push(new StringBuilder("" + c));
            }
            else if (c >= 'a' && c <= 'z') {
                if (stk.peek().charAt(0) >= 'a' && stk.peek().charAt(0) <= 'z') {
                    stk.peek().append(c);
                }
                else {
                    stk.push(new StringBuilder("" + c));
                }
            }
            else if (c == ']') {
    StringBuilder temp = new StringBuilder();

    while (!stk.peek().toString().equals("[")) {
        temp.insert(0, stk.pop());
    }

    stk.pop(); // [

    StringBuilder num = stk.pop();

    int temp3 = Integer.parseInt(num.toString());
    StringBuilder temp4 = new StringBuilder();

    for (int j = 0; j < temp3; j++) {
        temp4.append(temp);
    }

    if (!stk.isEmpty() && stk.peek().charAt(0) >= 'a' && stk.peek().charAt(0) <= 'z') {
        stk.peek().append(temp4);
    }
    else {
        stk.push(temp4);
    }
}
            else {
                if (stk.peek().charAt(0) >= '1' && stk.peek().charAt(0) <= '9') {
                    stk.peek().append(c);
                }
                else {
                    stk.push(new StringBuilder("" + c));
                }
            }
        }

        StringBuilder ans = new StringBuilder();

while (!stk.isEmpty()) {
    ans.insert(0, stk.pop());
}

return ans.toString();
    }
}