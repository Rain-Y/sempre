package edu.stanford.nlp.sempre.tables.serialize;

import edu.stanford.nlp.sempre.*;
import fig.exec.Execution;

/**
 * Load the examples and derivations from SerealizeDumper.
 */
public class SerializedLoader implements Runnable {

  public static void main(String[] args) {
    Execution.run(args, "SerializedLoaderMain", new SerializedLoader(), Master.getOptionsParser());
  }

  public void run() {
    Builder builder = new Builder();
    builder.build();

    Dataset dataset = new SerializedDataset();
    dataset.read();

    Learner learner = new Learner(builder.parser, builder.params, dataset);
    learner.learn();
  }

}
