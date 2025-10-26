class Solution {
    public int leastInterval(char[] tasks, int n) {

        if(tasks== null|| tasks.length == 0) return  0;
        if(n == 0 ) return tasks.length;

        int[] freq = new int[26];
        for(char c :tasks) freq[c-'A']++;
        
        int maxFreq = 0;
        for(int f : freq) maxFreq = Math.max(f,maxFreq);

        int countMaxFreq = 0;
        for(int f : freq) if(f == maxFreq) countMaxFreq++;

        int base = (maxFreq-1) * (n+1);
        int candidate = base + countMaxFreq;
        return Math.max(tasks.length, candidate);
    }
}