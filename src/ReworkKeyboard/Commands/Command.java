package ReworkKeyboard.Commands;

/**
 * Интерфейс для создания выполнения комманды
  */
public interface Command {  /// функциональный интерфейс.
    void execute();
    void undo();
}