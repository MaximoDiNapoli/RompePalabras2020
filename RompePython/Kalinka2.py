from tkinter import *      
from tkinter import scrolledtext

def clicked():
    root.destroy()
     
def clicked2():
    nombri = text3.get("1.0", "end-1c")
    if (nombri == nombrus):
        franiki.destroy()
        framur.pack()
        pass
    else:
        labeluR = Label(franiki, text="Usuario no encontrado")
        labeluR.pack()
        pass
    

    
def clicked3():
    framur.destroy()
    franunki.pack()

def clicked4():
    labelu = Label(franalki, text = "Respuesta correcta")
    labelu.grid(column=1, row=0)
    franunki.destroy()
    franalki.pack()
    pass

def clicked5():
    labelu = Label(franalki, text = "Respuesta incorrecta")
    labelu.grid(column=1, row=0)
    franunki.destroy()
    franalki.pack()
    pass

def clicked6():
    franalki.destroy()
    franunki.pack()
    pass

def clicked7():
    franalki.destroy()
    framur.pack()
    pass

nombrus = "SegismundoGoodKing41"
root = Tk()      
selected = IntVar()
franiki = Frame()
canvas = Canvas(franiki, width = 220, height = 210)   
img = PhotoImage(file="PalabraRota.png")      
canvas.create_image(30,30, anchor=NW, image=img)
text3 = Text(franiki, width = 35, height = 1)
labelu4 = Label(franiki, text="Nombre:")
text3.insert(INSERT, "")
butony = Button(franiki, text="Ingresar", width = 20, command=clicked2)
butony4 = Button(franiki, text="Salir", width = 20, command=clicked)
canvas.pack()  
labelu4.pack()    
text3.pack()
butony.pack()
butony4.pack()
franiki.pack()
        

Przyjaciele = ["FriedrichPrussen74", "CarolusAdolphusSweedenForTheWin", "MustafaPashaKebab67"]
winned = "Partidas Ganadas: 69"
sao = "Si: Kaczki!!! Yay!!!"
nombrianni = "Nombre: SegismundoGoodKing41"
framur = Frame()
labeluN2 = Label(framur, text= nombrianni)
labeluN3 = Label(framur, text= winned)
labeluN = Label(framur, text= sao)
labelu = Label(framur, text="Informacion de Usuario:")
labelu.grid(column=1, row=0, sticky = S)
labeluN2.grid(column=1, row=2)
labeluN3.grid(column=1, row=3)
labeluN.grid(column=1, row=1)
labelu2 = Label(framur, text="Przyjaciele:")
labelu2.grid(column=1, row=4)
nanie = 5
for nombranie in Przyjaciele:
    
    labeluP = Label(framur, text= nombranie)
    labeluP.grid(column=1, row=nanie)
    nanie = nanie + 1
    pass
butony2 = Button(framur, text="Buscar Partida", width = 20, command=clicked3)
butony2.grid(column=0, row=3)
butony3 = Button(framur, text="Salir", width = 20, command=clicked)
butony3.grid(column=0, row=4)


franunki = Frame()
pregunta = "Co kolorowy jest czerwony?"
respuesta1 = "To nie"
respuesta2 = "To tez nie"
respuesta3 = "To mniej"
respuesta4 = "To tak"
correcta = 4
labelu = Label(franunki, text = pregunta)
labelu.grid(column=2, row=0)
if correcta == 1:
    butony1 = Button(franunki, text= respuesta1, width = 20, bg = "blue", command=clicked4)
    pass
else:
    butony1 = Button(franunki, text= respuesta1, width = 20, bg = "blue", command=clicked5)
    pass

if correcta == 2:
    butony2 = Button(franunki, text= respuesta2, width = 20, bg = "green", command=clicked4)
    pass
else:
    butony2 = Button(franunki, text= respuesta2, width = 20, bg = "green", command=clicked5)
    pass

if correcta == 3:
    butony3 = Button(franunki, text= respuesta3, width = 20, bg = "yellow", command=clicked4)
    pass
else:
    butony3 = Button(franunki, text= respuesta3, width = 20, bg = "yellow", command=clicked5)
    pass

if correcta == 4:
    butony4 = Button(franunki, text= respuesta4, width = 20, bg = "red", command=clicked4)
    pass
else:
    butony4 = Button(franunki, text= respuesta4, width = 20, bg = "red", command=clicked5)
    pass
butony1.grid(column=0, row=1)
butony2.grid(column=1, row=1)
butony3.grid(column=3, row=1)
butony4.grid(column=4, row=1)


franalki = Frame()
labelu.grid(column=1, row=0)
butonia = Button(franalki, text= "Volver a jugar", width = 20, bg = "green", command=clicked6)
butonia2 = Button(franalki, text= "Volver al menu", width = 20, bg = "red", command=clicked7)
butonia.grid(column = 0, row = 1)
butonia2.grid(column = 2, row = 1)





mainloop()