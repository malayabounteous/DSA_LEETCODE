class Solution {

    private void generate(int i, int j, int on, Set<String> set, int[] hour, int[] minute, int hr, int min) {
         if (hr >= 12 || min >=60)
                return;
        if (on == 0) {
           
            if (hr == 0 && min == 0)
                return;
            String h = String.valueOf(hr);

            String m = String.valueOf(min);
            if (min < 10)
                m = "0" + m;
            h += ":";
            h += m;
            set.add(h);
            return;
        }
        if (i == 4 && j == 6)
            return;
        if (i<4 && hr + hour[i] < 12) {
            generate(i + 1, j, on - 1, set, hour, minute, hr + hour[i], min);
        }
        if (j<6 && min + minute[j] < 60) {
            generate(i, j + 1, on - 1, set, hour, minute, hr, min + minute[j]);
        }
        if(i<4)
        generate(i + 1, j, on, set, hour, minute, hr, min);
        if(j<6)
        generate(i, j + 1, on, set, hour, minute, hr, min);

    }

    public List<String> readBinaryWatch(int turnedOn) {

        Set<String> set = new HashSet<>();
        if (turnedOn == 0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add("0:00");
            return ans;
        }

        int[] hour = { 8, 4, 2, 1 };
        int[] minute = { 32, 16, 8, 4, 2, 1 };
        generate(0, 0, turnedOn, set, hour, minute, 0, 0);

        var ans = new ArrayList<String>(set);
        Collections.sort(ans);
        return ans;

    }
}