# coding: utf-8


from PyQt5.QtGui import QFont
from PyQt5.QtWidgets import (QWidget, QLabel, QLineEdit, QGroupBox, QFormLayout,  QScrollArea, QVBoxLayout)
from genero import Genero
from nome import Nome
from cpf import Cpf
from endereco import Endereco
from contato import Contato


class Formulario(QWidget):
    def __init__(self, *args, **kwargs):
        super(Formulario, self).__init__(*args, **kwargs)

        # grupos
        self.grupo_nome = Nome()
        self.grupo_genero = Genero()
        self.grupo_cpf = Cpf()
        self.endereco = Endereco()
        self.contato = Contato()
        self.contato.setFixedHeight(400)
       
        # layout
        layout = QFormLayout()
        layout.addWidget(self.grupo_nome)
        layout.addWidget(self.grupo_genero)
        layout.addWidget(self.grupo_cpf)
        layout.addWidget(self.endereco)
        layout.addWidget(self.contato)
        
        # scroll area
        # como possui muitas informações, é necessesário um scroll para navegar
        widget_scroll = QWidget()
        widget_scroll.setLayout(layout)

        scroll_area = QScrollArea()
        scroll_area.setWidgetResizable(True)
        scroll_area.setWidget(widget_scroll)

        layout_scroll = QVBoxLayout()
        layout_scroll.addWidget(scroll_area)
        self.setLayout(layout_scroll)


if __name__ == '__main__':
    import sys
    from PyQt5.QtWidgets import QApplication
    from PyQt5.QtGui import QFont
    from window import Window

    app = QApplication([])
    app.setFont(QFont('Geogia', 12))

    programa = Window()
    programa.setCentralWidget(Formulario())

    programa.show()
    sys.exit(app.exec_())
