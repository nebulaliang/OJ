package gasStation;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int index = 0;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i + 1;
            }
        }

        return total >= 0 ? index % n : -1;
    }
}
