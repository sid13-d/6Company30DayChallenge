package Microsoft.FindCityWithSmallestNeighbour;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        for(int []edge: edges) {
            int from = edge[0];
            int to= edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        for(int i=0; i<n; i++) {
            dist[i][i] = 0;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(dist[i][k] == (int) (1e9) || dist[k][j] == (int) (1e9)){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int minReachableCities = n;
        int optimalCity = -1;

        for(int city=0; city<n; city++) {
            int reachableCities = 0;
            for(int adjCity=0; adjCity<n; adjCity++) {
                if(dist[city][adjCity] <= distanceThreshold) {
                    reachableCities++;
                }

            }

            if(reachableCities <= minReachableCities) {
                if(reachableCities < minReachableCities || city > optimalCity) {
                    minReachableCities = reachableCities;
                    optimalCity = city;
                }
            }
        }

        return optimalCity;

    }
}
