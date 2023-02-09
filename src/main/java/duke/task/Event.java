package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import duke.exception.DukeException;
import duke.parser.Parser;

/**
 * Represents an Event task that has a description, a start date and time as well as an end date and time.
 */
public class Event extends Task {
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy HHmm");

    /**
     * Constructor for Event task, loaded from the storage file.
     * @param input Description of task including event time.
     * @param isDone Whether the task is marked or unmarked.
     */
    public Event(String input, boolean isDone) {
        super(input, isDone);
        this.symbol = 'E';
        String[] temp = input.split(",");
        this.description = temp[0];
        String[] dueArr = temp[1].split(" to ");
        this.startTime = LocalDateTime.parse(dueArr[0], displayFormatter);
        this.endTime = LocalDateTime.parse(dueArr[1], displayFormatter);
        this.duedateString = temp[1];
    }

    /**
     * Constructor a new Event task keyed in by the user.
     * @param input Description and event time of the task, including its header "event".
     * @throws DukeException If description is empty, or event time keyed in does not fit specified format.
     */
    public Event(String input) throws DukeException {
        super(input);
        this.symbol = 'E';
        String[] inputArr = input.split(" ", 2); //split 'event' from task input
        if (inputArr.length == 1 || inputArr[1].isBlank()) {
            throw new DukeException("Sorry, the description of an event cannot be empty!");
        }
        String[] eventArr = inputArr[1].split("/", 2); //split description from timings
        if (eventArr.length == 1 || eventArr[1].isBlank()) {
            throw new DukeException("Please include duration of the event in the following format:"
                                     + " /<yyyy-MM-dd HHmm> to <yyyy-MM-dd HHmm>");
        }
        this.description = eventArr[0];
        String[] dueArr = eventArr[1].split(" to ");
        this.startTime = Parser.parseDateTime(dueArr[0]);
        this.endTime = Parser.parseDateTime(dueArr[1]);
        this.duedateString = startTime.format(displayFormatter) + " to " + endTime.format(displayFormatter);
    }
    public String saveTask() {
        return this.symbol + "," + isDone + "," + this.description + "," + duedateString;
    }
}


//sample input: event project meeting /2023-01-30 0900 to 2023-01-30 1800