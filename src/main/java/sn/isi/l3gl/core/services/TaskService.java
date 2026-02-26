package sn.isi.l3gl.core.services;

import sn.isi.l3gl.core.entities.Task;
import sn.isi.l3gl.core.entities.TaskStatus;
import sn.isi.l3gl.core.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        // Par défaut, on peut forcer le statut à TODO à la création
        if (task.getStatus() == null) {
            task.setStatus(TaskStatus.TODO);
        }
        return taskRepository.save(task);
    }
}