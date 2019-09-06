package com.grepiu.sample.webflux.process.utils;

import java.time.LocalDateTime;
import java.util.Random;

public class SampleWorkers {

  public static String randomWorker() {
    return "Job Complete " + LocalDateTime.now();
  }
}
