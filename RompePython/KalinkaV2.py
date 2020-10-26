from tkinter import *      
from tkinter import scrolledtext
import random


class App():
    def __init__(self, root):
        self.root = root
        self.nombrus = "SegismundoGoodKing41"
        self.Przyjaciele = ["FriedrichPrussen74", "CarolusAdolphusSweedenForTheWin", "MustafaPashaKebab67"]
        self.winned = "Partidas Ganadas: 69"
        self.sao = "Si: Kaczki!!! Yay!!!"
        self.nombrianni = "Nombre: SegismundoGoodKing41"
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


        self.login()



    def login(self):    
        self.franiki = Frame()
        self.canvas = Canvas(self.franiki, width = 220, height = 210)   
        self.img = PhotoImage(file="PalabraRota.png")      
        self.canvas.create_image(30,30, anchor=NW, image=self.img)
        self.text3 = Text(self.franiki, width = 35, height = 1)
        self.labelu4 = Label(self.franiki, text="Nombre:")
        self.text3.insert(INSERT, "")
        self.butony = Button(self.franiki, text="Ingresar", width = 20, command=self.clicked2)
        self.butony4 = Button(self.franiki, text="Salir", width = 20, command=self.clicked)
        self.canvas.pack()  
        self.labelu4.pack()    
        self.text3.pack()
        self.butony.pack()
        self.butony4.pack()
        self.franiki.pack()



    def menu(self):
        self.framur = Frame()
        self.labeluN2 = Label(self.framur, text= self.nombrianni)
        self.labeluN3 = Label(self.framur, text= self.winned)
        self.labeluN = Label(self.framur, text= self.sao)
        self.labelu = Label(self.framur, text="Informacion de Usuario:")
        self.labelu.grid(column=1, row=0, sticky = S)
        self.labeluN2.grid(column=1, row=2)
        self.labeluN3.grid(column=1, row=3)
        self.labeluN.grid(column=1, row=1)
        self.labelu2 = Label(self.framur, text="Przyjaciele:")
        self.labelu2.grid(column=1, row=4)
        self.nanie = 5
        for nombranie in self.Przyjaciele:
            
            self.labeluP = Label(self.framur, text= nombranie)
            self.labeluP.grid(column=1, row=self.nanie)
            self.nanie = self.nanie + 1
            pass
        self.butony2 = Button(self.framur, text="Buscar Partida", width = 20, command=self.clicked3)
        self.butony2.grid(column=0, row=3)
        self.butony3 = Button(self.framur, text="Salir", width = 20, command=self.clicked)
        self.butony3.grid(column=0, row=4)


    def partida(self):
        self.numeroR = random.choice(self.setPreguntas)
        self.franunki = Frame()
        self.labelu = Label(self.franunki, text = self.pregunta[self.numeroR])
        self.labelu.grid(column=2, row=0)
        if self.correcta[self.numeroR] == 1:
            self.butony1 = Button(self.franunki, text= self.setRespuestas[self.numeroR][0], width = 20, height = 2, bg = "blue", command=self.clicked4)
            pass
        else:
            self.butony1 = Button(self.franunki, text= self.setRespuestas[self.numeroR][0], width = 20, height = 2, bg = "blue", command=self.clicked5)
            pass

        if self.correcta[self.numeroR] == 2:
            self.butony2 = Button(self.franunki, text= self.setRespuestas[self.numeroR][1], width = 20, height = 2, bg = "green", command=self.clicked4)
            pass
        else:
            self.butony2 = Button(self.franunki, text= self.setRespuestas[self.numeroR][1], width = 20, height = 2, bg = "green", command=self.clicked5)
            pass

        if self.correcta[self.numeroR] == 3:
            self.butony3 = Button(self.franunki, text= self.setRespuestas[self.numeroR][2], width = 20, height = 2, bg = "yellow", command=self.clicked4)
            pass
        else:
            self.butony3 = Button(self.franunki, text= self.setRespuestas[self.numeroR][2], width = 20, height = 2, bg = "yellow", command=self.clicked5)
            pass

        if self.correcta[self.numeroR] == 4:
            self.butony4 = Button(self.franunki, text= self.setRespuestas[self.numeroR][3], width = 20, height = 2, bg = "red", command=self.clicked4)
            pass
        else:
            self.butony4 = Button(self.franunki, text= self.setRespuestas[self.numeroR][3], width = 20, height = 2, bg = "red", command=self.clicked5)
            pass
        self.butony1.grid(column=1, row=1)
        self.butony2.grid(column=1, row=2)
        self.butony3.grid(column=3, row=1)
        self.butony4.grid(column=3, row=2)


    def resultadoP(self):
        self.franalki = Frame()
        self.labelu.grid(column=1, row=0)
        self.butonia = Button(self.franalki, text= "Volver a jugar", width = 20, bg = "green", command=self.clicked6)
        self.butonia2 = Button(self.franalki, text= "Volver al menu", width = 20, bg = "red", command=self.clicked7)
        self.butonia.grid(column = 0, row = 1)
        self.butonia2.grid(column = 2, row = 1)
    
    def clicked(self):
        self.root.destroy()
        
    def clicked2(self):
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
        

        
    def clicked3(self):
        self.framur.destroy()
        self.partida()
        self.franunki.pack()

    def clicked4(self):
        self.resultadoP()
        self.labelu = Label(self.franalki, text = "Respuesta correcta")
        self.labelu.grid(column=1, row=0)
        self.franunki.destroy()
        self.franalki.pack()
        pass

    def clicked5(self):
        self.resultadoP()
        self.labelu = Label(self.franalki, text = "Respuesta incorrecta")
        self.labelu.grid(column=1, row=0)
        self.franunki.destroy()
        self.franalki.pack()
        pass

    def clicked6(self):
        self.franalki.destroy()
        self.partida()
        self.franunki.pack()
        pass

    def clicked7(self):
        self.franalki.destroy()
        self.menu()
        self.framur.pack()
        pass
















root = Tk()
app = App(root)


mainloop() 