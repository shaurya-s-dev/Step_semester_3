package object_modeling.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class LabScene {
    private String sceneName;

    // A step is: capability, command, value
    private static class Step {
        String capabilityName;
        String command;
        Object value;

        Step(String capabilityName, String command, Object value) {
            this.capabilityName = capabilityName;
            this.command = command;
            this.value = value;
        }
    }

    private List<Step> steps;

    public LabScene(String sceneName) {
        this.sceneName = sceneName;
        this.steps = new ArrayList<>();
    }

    public String getSceneName() {
        return sceneName;
    }

    public void addStep(String capabilityName, String command, Object value) {
        steps.add(new Step(capabilityName, command, value));
    }

    public List<String> apply(List<LabDevice> devices) {
        List<String> results = new ArrayList<>();
        for (Step step : steps) {
            for (LabDevice device : devices) {
                if (device.hasCapability(step.capabilityName)) {
                    results.add(device.applyCommand(step.capabilityName, step.command, step.value));
                }
            }
        }
        return results;
    }
}
