#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

string sortString(string s) {
    string sorted = s;
    sort(sorted.begin(), sorted.end());
    return sorted;
}

bool findMatch(string a, string b) {
    string s = sortString(a);
    for (int i = 0; i <= b.size() - a.size(); i++) {
        string sub = sortString(b.substr(i, a.size()));
        if (s == sub) {
            return true;
        }       
    }
    return false;
}

int main(int argc, char** argv) {
    vector<string> names = {
        "RAKIBUL",
        "ANINDYA",
        "MOSHIUR",
        "SHIPLU",
        "KABIR",
        "SUNNY",
        "OBAIDA",
        "WASI"
    };
    vector<string> grid = {
        "OBIDAIBKR",
        "RKAULHISP",
        "SADIYANNO",
        "HEISAWHIA",
        "IRAKIBULS",
        "MFBINTRNO",
        "UTOYZIFAH",
        "LEBSYNUNE",
        "EMOTIONAL"
    };
    map<string, int> namesMap;

    // load vertically aligned letters
    for (int col = 0; col < grid[0].size(); col++) {
        string s = "";
        for (int row = 0; row < grid.size(); row++) {
            s += grid[row][col];
        }
        grid.push_back(s);
    }
    
    for (int i = 0; i < names.size(); i++) {
        namesMap[names[i]] = 0;      
        for (int j = 0; j < grid.size(); j++) {
            if (findMatch(names[i], grid[j])) {
                namesMap[names[i]] += 1; 
            }
            if (namesMap[names[i]] >= 2) {
                cout << names[i] << "\n";
                return 0;
            }
        }
    }
    return 0;
}
