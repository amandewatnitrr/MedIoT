import React from 'react';
import './Doctors.css';
import faker from 'faker';
// import { makeStyles } from '@material-ui/core/styles';
import {
    Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, makeStyles, Avatar,
    Grid, Typography, TablePagination, TableFooter
} from '@material-ui/core';

let DOCTORS = [], STATUSES = ['Online', 'Offline'];;
for (let i = 0; i < 15; i++) {
    DOCTORS[i] = {
        name: faker.name.findName(),
        email: faker.internet.email(),
        doctorid: faker.finance.routingNumber(),
        city: faker.address.city(),
        country: faker.address.country(),
        gethelp: 'Connect',
        status: STATUSES[Math.floor(Math.random() * STATUSES.length)]
    }
}

const useStyles = makeStyles((theme) => ({
    table: {
        minWidth: 650,
    },
    tableContainer: {
        borderRadius: 15,
        margin: '10px 10px',
        // maxWidth: 950
        flex: 5
    },
    tableHeaderCell: {
        fontWeight: 'bold',
        backgroundColor: theme.palette.primary.dark,
        color: theme.palette.getContrastText(theme.palette.primary.dark)
    },
    avatar: {
        backgroundColor: theme.palette.primary.light,
        color: theme.palette.getContrastText(theme.palette.primary.light)
    },
    name: {
        fontWeight: 'bold',
        color: theme.palette.secondary.dark
    },
    status: {
        fontWeight: 'bold',
        fontSize: '0.75rem',
        color: 'white',
        backgroundColor: 'grey',
        borderRadius: 8,
        padding: '3px 10px',
        display: 'inline-block'
    }
}));

export default function Doctors() {

    const classes = useStyles();
    const [page, setPage] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(5);

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(+event.target.value);
        setPage(0);
    };

    return (
        <TableContainer component={Paper} className={classes.tableContainer}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell className={classes.tableHeaderCell}>Name</TableCell>
                        <TableCell className={classes.tableHeaderCell}>City</TableCell>
                        <TableCell className={classes.tableHeaderCell}>Doctor ID</TableCell>
                        <TableCell className={classes.tableHeaderCell}>Get Help</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {DOCTORS.map((row) => (
                        <TableRow key={row.name}
                        // sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                        >
                            <TableCell>
                                <Grid container>
                                    <Grid item lg={2}>
                                        <Avatar alt={row.name} src='.' className={classes.avatar} />
                                    </Grid>
                                    <Grid item lg={10}>
                                        <Typography className={classes.name}>{row.name}</Typography>
                                        <Typography color="textSecondary" variant="body2">{row.email}</Typography>
                                        <Typography color="textSecondary" variant="body2">{row.phone}</Typography>
                                    </Grid>
                                </Grid>
                            </TableCell>
                            <TableCell>
                                <Typography color="primary" variant="subtitle2">{row.city}</Typography>
                                <Typography color="textSecondary" variant="body2">{row.country}</Typography>
                            </TableCell>
                            <TableCell>{row.doctorid}</TableCell>
                            <TableCell>
                                <Typography
                                    className={classes.status}
                                    style={{
                                        backgroundColor:
                                            ((row.status === 'Online' && 'green') ||
                                                (row.status === 'Offline' && 'orange'))
                                    }}
                                >{row.status}</Typography>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
                <TableFooter>
                    <TablePagination
                        rowsPerPageOptions={[5, 10, 15]}
                        component="div"
                        count={DOCTORS.length}
                        rowsPerPage={rowsPerPage}
                        page={page}
                        onChangePage={handleChangePage}
                        onChangeRowsPerPage={handleChangeRowsPerPage}
                    />
                </TableFooter>
            </Table>
        </TableContainer>
    );
}
