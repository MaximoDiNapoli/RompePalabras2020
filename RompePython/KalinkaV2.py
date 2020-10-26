from tkinter import *      
from tkinter import scrolledtext
import random
import time 
from tkinter import messagebox

class App():
    def __init__(self, root):
        self.root = root
        self.nombrus = "SegismundoGoodKing41"
        self.Przyjaciele = ["FriedrichPrussen74", "CarolusAdolphusSweedenForTheWin", "MustafaPashaKebab67"]
        self.nombrianni = "Nombre:" + self.nombrus
        self.setPreguntas = [0, 1, 2, 3, 4]
        self.pregunta = ["Co kolorowy jest czerwony?", "Carlos Martel evito que los bereberes entraran en...?", "La cacion One Way Or Another pertenece a...?", "Cuantos protones tiene el litio?", "Que libreria conecta sencillamente Python y MongoDb sin utilizar una API?"]
        self.setRespuestas = [0, 1, 1, 1], [1, 2, 1, 1], [1, 2, 1, 1], [1, 2, 1, 1], [1, 2, 1, 1]
        self.setRespuestas[0][0] = "To nie"
        self.setRespuestas[0][1] = "To tez nie"
        self.setRespuestas[0][2] = "To mniej"
        self.setRespuestas[0][3] = "To tak"
        self.setRespuestas[1][0] = "Francia"
        self.setRespuestas[1][1] = "Alemania"
        self.setRespuestas[1][2] = "Brazil"
        self.setRespuestas[1][3] = "Marruecos"
        self.setRespuestas[2][0] = "Blondie"
        self.setRespuestas[2][1] = "Depeche Mode"
        self.setRespuestas[2][2] = "Ensiferum"
        self.setRespuestas[2][3] = "Bjork"
        self.setRespuestas[3][0] = "10"
        self.setRespuestas[3][1] = "21"
        self.setRespuestas[3][2] = "13"
        self.setRespuestas[3][3] = "3"
        self.setRespuestas[4][0] = "PyMongo"
        self.setRespuestas[4][1] = "MongoPy"
        self.setRespuestas[4][2] = "PyMo"
        self.setRespuestas[4][3] = "MongoConnect"

        self.correcta = [4, 1, 1, 4, 1]      
        self.puntaje = 0
        self.jugados = 0
        self.respondido = 0

        self.login()



    def login(self):    
        self.franiki = Frame()
        self.canvas = Canvas(self.franiki, width = 220, height = 210)   
        self.img = PhotoImage(file="PalabraRota.png")      
        self.canvas.create_image(30,30, anchor=NW, image=self.img)
        self.text3 = Text(self.franiki, width = 35, height = 1)
        self.labelu4 = Label(self.franiki, text="Nombre:")
        self.text3.insert(INSERT, "")
        self.butony = Button(self.franiki, text="Ingresar", width = 20, command=self.VerificarCuenta)
        self.butony4 = Button(self.franiki, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.canvas.pack()  
        self.labelu4.pack()    
        self.text3.pack()
        self.butony.pack()
        self.butony4.pack()
        self.franiki.pack()



    def menu(self):
        self.framur = Frame()
        self.labeluN2 = Label(self.framur, text= self.nombrianni)
        self.labelu = Label(self.framur, text="Informacion de Usuario:")
        
        self.labelu.grid(column=1, row=0, sticky = S)
        self.labeluN2.grid(column=1, row=2)
        self.labelu2 = Label(self.framur, text="Przyjaciele:")
        self.labelu2.grid(column=1, row=4)
        self.nanie = 5
        for nombranie in self.Przyjaciele:
            self.labeluP = Label(self.framur, text= nombranie)

            self.labeluP.grid(column=1, row=self.nanie)
            self.nanie = self.nanie + 1
            pass
        self.butony2 = Button(self.framur, text="Buscar Partida", width = 20, command=self.BuscarPartida)
        self.butony2.grid(column=0, row=3)
        self.butony3 = Button(self.framur, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.butony3.grid(column=0, row=4)


    def partida(self):
        self.numeroR = random.choice(self.setPreguntas)
        self.franunki = Frame()
        self.labelu = Label(self.franunki, text = self.pregunta[self.numeroR])
        self.labelu.grid(column=2, row=0)
        if self.correcta[self.numeroR] == 1:
            self.butony1 = Button(self.franunki, text= self.setRespuestas[self.numeroR][0], width = 20, height = 2, bg = "blue", command=self.RespuestaCorrecta)
            pass
        else:
            self.butony1 = Button(self.franunki, text= self.setRespuestas[self.numeroR][0], width = 20, height = 2, bg = "blue", command=self.RespuestaIncorrecta)
            pass

        if self.correcta[self.numeroR] == 2:
            self.butony2 = Button(self.franunki, text= self.setRespuestas[self.numeroR][1], width = 20, height = 2, bg = "green", command=self.RespuestaCorrecta)
            pass
        else:
            self.butony2 = Button(self.franunki, text= self.setRespuestas[self.numeroR][1], width = 20, height = 2, bg = "green", command=self.RespuestaIncorrecta)
            pass

        if self.correcta[self.numeroR] == 3:
            self.butony3 = Button(self.franunki, text= self.setRespuestas[self.numeroR][2], width = 20, height = 2, bg = "yellow", command=self.RespuestaCorrecta)
            pass
        else:
            self.butony3 = Button(self.franunki, text= self.setRespuestas[self.numeroR][2], width = 20, height = 2, bg = "yellow", command=self.RespuestaIncorrecta)
            pass

        if self.correcta[self.numeroR] == 4:
            self.butony4 = Button(self.franunki, text= self.setRespuestas[self.numeroR][3], width = 20, height = 2, bg = "red", command=self.RespuestaCorrecta)
            pass
        else:
            self.butony4 = Button(self.franunki, text= self.setRespuestas[self.numeroR][3], width = 20, height = 2, bg = "red", command=self.RespuestaIncorrecta)
            pass
        self.butony1.grid(column=1, row=1)
        self.butony2.grid(column=1, row=2)
        self.butony3.grid(column=3, row=1)
        self.butony4.grid(column=3, row=2)
        self.respondido = 0
        


    def resultadoP(self):
        self.franalki = Frame()
        self.butonia = Button(self.franalki, text= "Volver a jugar", width = 20, bg = "green", command=self.VolverAJugar)
        self.butonia2 = Button(self.franalki, text= "Volver al menu", width = 20, bg = "red", command=self.VolverAlMenu)
        
        self.labelu = Label(self.franalki, text = "Puntuacion: " + self.puntaje.__str__())
        self.puntaje = 0
        self.labelu.grid(column=1, row=1)
        self.butonia.grid(column = 0, row = 2)
        self.butonia2.grid(column = 2, row = 2)
    
    def SalirDeLaApp(self):
        self.root.destroy()
        
    def VerificarCuenta(self):
        self.nombri = self.text3.get("1.0", "end-1c")
        if (self.nombri == self.nombrus):
            self.franiki.destroy()
            self.menu()
            self.framur.pack()
            pass
        else:
            self.labeluR = Label(self.franiki, text="Usuario no encontrado")
            self.labeluR.pack()
            pass
        

        
    def BuscarPartida(self):
        self.framur.destroy()
        self.partida()
        self.franunki.pack()
        self.Timer()


    def RespuestaCorrecta(self):
        self.respondido = 1
        self.puntaje = self.puntaje + 1
        self.franunki.destroy()
        if self.jugados == 3:
            self.resultadoP()
            self.labelu = Label(self.franalki, text = "Respuesta correcta")
            self.labelu.grid(column=1, row=0)
            
            self.franalki.pack()
            self.jugados = 0
            pass
        else:
            self.partida()
            self.jugados = self.jugados + 1
            self.franunki.pack()
            self.Timer()
            pass
        pass

    def RespuestaIncorrecta(self):
        self.respondido = 1
        self.franunki.destroy()
        if self.jugados == 3:
            self.resultadoP()
            self.labelu = Label(self.franalki, text = "Respuesta incorrecta")
            self.labelu.grid(column=1, row=0)
            
            self.franalki.pack()
            self.jugados = 0
            pass
        else:
            self.partida()
            self.jugados = self.jugados + 1
            self.franunki.pack()
            self.Timer()
            pass
        pass

    def VolverAJugar(self):
        self.franalki.destroy()
        self.partida()
        self.franunki.pack()
        self.Timer()
        pass

    def VolverAlMenu(self):
        self.franalki.destroy()
        self.menu()
        self.framur.pack()
        pass

    def Timer(self):
        self.timer = StringVar()
        self.timer.set("00")
        self.TRestante = Entry(self.franunki, font=("Arial",18,""), 
                                              textvariable = self.timer)
        self.TRestante.grid(column=2, row=1)
        self.t = 30
        while self.t > -1: 
            if self.respondido == 0:
                mins, secs = divmod(self.t, 60)
                self.timer.set('{:02d}'.format(secs) )
                self.root.update()
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                time.sleep(0.05)
                pass
            
            self.t -= 1
        pass

















root = Tk()
app = App(root)


mainloop() 