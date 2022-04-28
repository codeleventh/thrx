
package ru.eleventh;

import lombok.val;

import java.util.stream.IntStream;

import static java.lang.Integer.*;

public class Thrx {
    public static long calculateWaterAmount(int[] landscape) {
        // Let there be an expanse in the midst of the waters, and let it separate the waters from the waters!

        val sortedList = IntStream
                .range(0, landscape.length)
                .peek(i -> {
                    assert landscape[i] >= 0 : "Landscape height cannot be negative!";
                }).mapToObj(i -> new LandscapePair(i, landscape[i]))
                .filter(pair -> pair.height > 0)
                .sorted(((o1, o2) -> compare(o2.height, o1.height)))
                .toList();

        long answer = 0;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;

        for (int i = 1; i < sortedList.size(); i++) {
            LandscapePair current = sortedList.get(i), prev = sortedList.get(i - 1);

            var minPos = min(current.pos, prev.pos);
            var maxPos = max(current.pos, prev.pos);
            if (minPos < l) maxPos = min(maxPos, l);
            else minPos = max(minPos, r);
            val spaceBetween = maxPos - minPos - 1;

            if (spaceBetween == 0) continue;
            if (minPos >= l && maxPos <= r) continue;

            int floodHeight = min(current.height, prev.height);
            answer += (long) floodHeight * spaceBetween;
            for (int j = 1; j <= spaceBetween; j++)
                answer -= min(floodHeight, landscape[minPos + j]);

            l = min(l, minPos);
            r = max(r, maxPos);
        }

        return answer;
    }

    public static void main(String[] args) {
        val input = new int[]{3, 1, 2, 3, 0, 0, 6};
        System.out.println(calculateWaterAmount(input));
    }
}
