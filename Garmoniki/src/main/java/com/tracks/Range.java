package com.tracks;

public interface Range {
    int getStartFreq();
    int getStopFreq();
    Range crossRange(Range other);
    Range dividedRange(int n);
    Range inverseRange();
    Range moveRange(int value);
}
