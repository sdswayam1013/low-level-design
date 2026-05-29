package main

type Direction int

const (
	Up Direction = iota
	Down
	Idle
)

type status int

const (
	Idle1 status = iota
	moving
)

type display struct {
	floor     int
	direction Direction
}

type Request struct {
	floor int
}

type Elevator struct {
	id              int
	currentFloor    int
	display         display
	direction       Direction
	status          status
	incomingRequest []Request
}

func (e *Elevator) NewRequest(r Request) {
	e.incomingRequest = append(e.incomingRequest, r)
}

func (e *Elevator) Move() {
	if len(e.incomingRequest) == 0 {
		e.status = Idle1
		e.direction = Idle
		return
	}
	var request Request
	request = e.incomingRequest[0]

	for e.currentFloor != request.floor {
		if e.currentFloor < request.floor {
			e.direction = Up
			e.currentFloor++
		} else {
			e.direction = Down
			e.currentFloor--
		}
	}
}

type ElevatorController struct {
	elevator *Elevator
}

func (c *ElevatorController) NewRequest(r Request) {
	c.elevator.NewRequest(r)
}

type InternalButtonDispatcher struct {
	controller *ElevatorController
}

func (d *InternalButtonDispatcher) SubmitRequest(floor int) {

	request := Request{
		floor: floor,
	}

	d.controller.NewRequest(request)
}

type InternalButton struct {
	dispatcher *InternalButtonDispatcher
}

func (b *InternalButton) PressButton(destination int) {
	b.dispatcher.SubmitRequest(destination)
}

func main() {

	elevator := &Elevator{
		id:           1,
		currentFloor: 0,
		direction:    IDLE,
	}

	controller := &ElevatorController{
		elevator: elevator,
	}

	dispatcher := &InternalButtonDispatcher{
		controller: controller,
	}

	button := &InternalButton{
		dispatcher: dispatcher,
	}

	button.PressButton(5)

	elevator.Move()
}
